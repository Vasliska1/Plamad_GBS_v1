package org.springframework.samples.petclinic.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlayerController {

	final PlayerRepository player;

	public PlayerController(PlayerRepository player) {
		this.player = player;
	}

	@RequestMapping(value="/player/{id}", method= RequestMethod.GET)
	@ResponseBody
	public String findById(@PathVariable("id") int id) {
		return player.findById(id).getNickname() + " " +  player.findById(id).getRegistrationDate() ;
	}

}
