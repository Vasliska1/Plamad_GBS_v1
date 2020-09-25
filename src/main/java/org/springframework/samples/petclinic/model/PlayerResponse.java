package org.springframework.samples.petclinic.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import java.io.Serializable;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PlayerResponse implements Serializable {
	private int id;
	private String nickname;
	private String date;

	public PlayerResponse(int id, String nickname, String date) {
		this.id = id;
		this.nickname = nickname;
		this.date = date;
	}
}
