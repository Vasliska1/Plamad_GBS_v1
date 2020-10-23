package org.springframework.samples.petclinic.model;

import java.time.LocalDateTime;

public class GameResult {

	private LocalDateTime date;
	private double score;
	private Player player;

	public LocalDateTime getDate() {
		return date;
	}

	public double getScore() {
		return score;
	}

	public Player getPlayer() {
		return player;
	}
	
}
