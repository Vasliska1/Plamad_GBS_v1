package org.springframework.samples.petclinic.model;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@Controller
public class GameResultController {

	final GameResultRepository gameResultRepository;

	public GameResultController(GameResultRepository gameResultRepository) {
		this.gameResultRepository = gameResultRepository;
	}

	@GetMapping("/top10Players")
	public String processFindForm(GameResult gameResult, BindingResult result, Map<String, Object> model) {

		// find owners by last name
		Collection<GameResult> results = this.gameResultRepository.getBestScore(10);
		if (results.isEmpty()) {
			// no owners found
			result.rejectValue("gameResult", "notFound", "not found");
			return "owners/findOwners";
		}

		else {
			// multiple owners found
			model.put("selections", results);
			return "gameResult/topResultList";
		}
	}


}
