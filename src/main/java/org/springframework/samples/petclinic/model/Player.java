package org.springframework.samples.petclinic.model;

import java.time.LocalDate;

public class Player {
	private String nickname;
	private LocalDate registrationDate;

	public String getPlayerResult() {
		return null;
	}

	public String getNickname() {
		return nickname;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}
}
