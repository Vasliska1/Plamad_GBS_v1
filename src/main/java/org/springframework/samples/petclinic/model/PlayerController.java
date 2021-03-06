package org.springframework.samples.petclinic.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Objects;

@Controller
public class PlayerController {

	private static final String VIEWS_PLAYER_CREATE_OR_UPDATE_FORM = "players/createPlayer";

	final PlayerRepository player;

	public PlayerController(PlayerRepository player) {
		this.player = player;
	}

	@RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView findById(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("players/playersInfo");
		Player player = this.player.findById(id);
		System.out.println(player.getRegistrationDate());
		mav.addObject(player);
		return mav;
	}

	@GetMapping("/player/{id}/edit")
	public String initUpdatePlayerForm(@PathVariable("id") int id, Model model) {
		Player player = this.player.findById(id);
		model.addAttribute(player);
		return VIEWS_PLAYER_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/player/{id}/edit")
	public String processUpdatePlayerForm(@Valid Player player, BindingResult result,
										  @PathVariable("id") int id) {
		if (result.hasErrors()) {
			return VIEWS_PLAYER_CREATE_OR_UPDATE_FORM;
		} else {
			player.setId(id);
			player.setRegistrationDate(LocalDateTime.now());
			this.player.save(player);
			System.out.println(player.getNickname());
			return "redirect:/player/{id}";
		}
	}


	@GetMapping("/player/new")
	public String initCreationForm(Map<String, Object> model) {
		Player player = new Player();
		model.put("player", player);
		return VIEWS_PLAYER_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/player/new")
	public String processCreationForm(@Valid Player player, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_PLAYER_CREATE_OR_UPDATE_FORM;
		} else {
			player.setRegistrationDate(LocalDateTime.now());
			this.player.save(player);
			return "redirect:/player/" + player.getId();
		}
	}

	@RequestMapping(value = "api/player/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> findByIdToJson(@PathVariable("id") int id) throws JsonProcessingException, FileNotFoundException {
		String jsonOk;
		String jsonError;
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			Player getPlayer = player.findById(id);
			if (getPlayer == null) {
				jsonError = ow.writeValueAsString(new ErrorResponse("404", "Not Found"));
				return new ResponseEntity<>(jsonError, HttpStatus.NOT_FOUND);
			} else {
				PlayerResponse player = new PlayerResponse(getPlayer.getId(), getPlayer.getNickname(), getPlayer.getRegistrationDate().toString());
				jsonOk = ow.writeValueAsString(player);
				return new ResponseEntity<>(jsonOk, HttpStatus.OK);
			}
		} catch (Exception e) {
			jsonError = ow.writeValueAsString(new ErrorResponse("500", "Internet Server Error"));
			return new ResponseEntity<>(jsonError, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "api/player/new", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> processCreationForm(HttpEntity<Map> httpEntity) throws JsonProcessingException {

		JSONObject jsonObject = new JSONObject(Objects.requireNonNull(httpEntity.getBody()));
		String name = jsonObject.get("nickname").toString();
		Player player = new Player();
		player.setNickname(name);
		player.setRegistrationDate(LocalDateTime.now());
		this.player.save(player);

		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(new PlayerResponse(player.getId(), player.getNickname(), player.getRegistrationDate().toString()));
		return new ResponseEntity<>(json, HttpStatus.CREATED);
	}

}
