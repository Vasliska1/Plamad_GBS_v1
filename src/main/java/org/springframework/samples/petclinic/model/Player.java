package org.springframework.samples.petclinic.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Player {
	private String nickname;
	private LocalDateTime registrationDate;

	public String getPlayerResult() {
		return null;
	}

	public String getNickname() {
		return nickname;
	}

	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
}
