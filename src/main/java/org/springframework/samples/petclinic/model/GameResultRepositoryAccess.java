package org.springframework.samples.petclinic.model;

import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class GameResultRepositoryAccess {

	private GameResultRepository gameResultRepository;

	public GameResultRepositoryAccess(GameResultRepository gameResultRepository) {
		this.gameResultRepository = gameResultRepository;

		List<GameResult> g = gameResultRepository.getAnyResultByScore(3);

		System.out.println(g.get(0).getScore() + " " + g.get(1).getScore() + " " + g.get(2).getScore());

	}


}
