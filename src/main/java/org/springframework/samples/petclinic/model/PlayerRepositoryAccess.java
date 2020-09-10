package org.springframework.samples.petclinic.model;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class PlayerRepositoryAccess {



	private PlayerRespository playerRespository;
	public PlayerRepositoryAccess(PlayerRespository playerRespository) {
		this.playerRespository =playerRespository;
		Player player = playerRespository.findById(1);
		Player player1 = new Player();
		player1.setRegistrationDate(LocalDateTime.now());
		player1.setNickname("123");
		playerRespository.save(player1);
		}



}
