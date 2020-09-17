package org.springframework.samples.petclinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;


@Entity
@Table(name = "player")
public class Player extends BaseEntity {

	@Column(name = "nickname")
	@NotEmpty
	private String nickname;

	@Column(name = "registration_date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
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
