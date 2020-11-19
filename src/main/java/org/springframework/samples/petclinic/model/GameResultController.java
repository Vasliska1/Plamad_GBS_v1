package org.springframework.samples.petclinic.model;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.util.*;

@Controller
public class GameResultController {

	final GameResultRepository gameResultRepository;
	final PlayerRepository playerRepository;

	public GameResultController(GameResultRepository gameResultRepository, PlayerRepository playerRepository) {
		this.gameResultRepository = gameResultRepository;
		this.playerRepository = playerRepository;
	}

	@GetMapping("/top10Players")
	public String processFindForm(GameResult gameResult, BindingResult result, Map<String, Object> model) {

		Collection<GameResult> results = this.gameResultRepository.getBestScore(10);
		model.put("selections", results);
		return "gameResult/topResultList";

	}


	@RequestMapping(value = "api/topPlayers/{count}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> getTopPlayersToJson(@PathVariable("count") int count) throws JsonProcessingException, FileNotFoundException {
		String jsonOk;
		String jsonError;
		List<GameResultResponse> gameResultResponses = new ArrayList<>();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			List<GameResult> getGameResult = gameResultRepository.getBestScore(count);
			if (getGameResult == null) {
				jsonError = ow.writeValueAsString(new ErrorResponse("404", "Not Found"));
				return new ResponseEntity<>(jsonError, HttpStatus.NOT_FOUND);
			} else {
				for (GameResult g : getGameResult) {
					gameResultResponses.add(new GameResultResponse(g.getPlayer().getNickname(), g.getScore(), g.getDate().toString()));
				}
				jsonOk = ow.writeValueAsString(gameResultResponses);
				return new ResponseEntity<>(jsonOk, HttpStatus.OK);
			}
		} catch (Exception e) {
			jsonError = ow.writeValueAsString(new ErrorResponse("500", "Internet Server Error"));
			return new ResponseEntity<>(jsonError, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@RequestMapping(value = "api/topPlayersLastWeek/{count}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> getTopPlayersLastWeekToJson(@PathVariable("count") int count) throws JsonProcessingException, FileNotFoundException {
		String jsonOk;
		String jsonError;
		List<GameResultResponse> gameResultResponses = new ArrayList<>();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			List<GameResult> getGameResult = gameResultRepository.getBestScoreLastWeek(count);
			if (getGameResult == null) {
				jsonError = ow.writeValueAsString(new ErrorResponse("404", "Not Found"));
				return new ResponseEntity<>(jsonError, HttpStatus.NOT_FOUND);
			} else {
				for (GameResult g : getGameResult) {
					gameResultResponses.add(new GameResultResponse(g.getPlayer().getNickname(), g.getScore(), g.getDate().toString()));
				}
				jsonOk = ow.writeValueAsString(gameResultResponses);
				return new ResponseEntity<>(jsonOk, HttpStatus.OK);
			}
		} catch (Exception e) {
			jsonError = ow.writeValueAsString(new ErrorResponse("500", "Internet Server Error"));
			return new ResponseEntity<>(jsonError, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "api/gameResult/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> processCreationForm(HttpEntity<Map> httpEntity) throws JsonProcessingException {

		JSONObject jsonObject = new JSONObject(Objects.requireNonNull(httpEntity.getBody()));
		int score = Integer.parseInt(jsonObject.get("score").toString());
		int playerId = Integer.parseInt(jsonObject.get("playerId").toString());

		Player player = playerRepository.findById(playerId);
		System.out.println(player.getNickname());
		GameResult gameResult = new GameResult();
		gameResult.setScore(score);
		gameResult.setPlayer(player);
		gameResult.setDate(LocalDateTime.now());
		this.gameResultRepository.save(gameResult);
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

		String json = ow.writeValueAsString(new GameResultResponse(gameResult.getPlayer().getNickname(), gameResult.getScore(), gameResult.getDate().toString()));
		return new ResponseEntity<>(json, HttpStatus.CREATED);
	}


}
