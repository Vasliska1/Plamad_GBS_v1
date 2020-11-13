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

		Collection<GameResult> results = this.gameResultRepository.getBestScore(10);
		model.put("selections", results);
		return "gameResult/topResultList";

	}
}
