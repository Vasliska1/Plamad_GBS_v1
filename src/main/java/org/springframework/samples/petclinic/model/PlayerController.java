package org.springframework.samples.petclinic.model;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PlayerController {

	private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "players/createPlayer";

	final PlayerRepository player;

	public PlayerController(PlayerRepository player) {
		this.player = player;
	}

	@RequestMapping(value = "/player/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView findById(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("players/findPlayers");
		Player player = this.player.findById(id);
		mav.addObject(player);
		return mav;
	}

	@GetMapping("/player/{id}/edit")
	public String initUpdateOwnerForm(@PathVariable("id") int id, Model model) {
		Player player = this.player.findById(id);
		model.addAttribute(player);
		return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
	}

	@PostMapping("/player/{id}/edit")
	public String processUpdateOwnerForm(@Valid Player player, BindingResult result,
										 @PathVariable("id") int id) {
		if (result.hasErrors()) {
			return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
		}
		else {
			player.setId(id);
			this.player.save(player);
			System.out.println(player.getNickname());
			return "redirect:/player/{id}";
		}
	}

}
