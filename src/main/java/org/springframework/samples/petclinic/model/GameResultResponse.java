package org.springframework.samples.petclinic.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class GameResultResponse implements Serializable {

	private String player;
	private int score;
	private String date;

	public GameResultResponse(String player, int score, String date) {
		this.player = player;
		this.score=score;
		this.date = date;
	}


}
