package org.springframework.samples.petclinic.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "player")
public class Player  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nickname")
	@NotEmpty
	private String nickname;

	@Column(name = "registretion_date")
	@NotEmpty
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
