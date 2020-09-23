package org.springframework.samples.petclinic.model;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Map;

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
		}
		else {
			player.setId(id);
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
		}
		else {
			this.player.save(player);
			return "redirect:/player/" + player.getId();
		}
	}

}
