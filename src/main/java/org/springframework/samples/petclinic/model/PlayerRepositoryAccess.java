package org.springframework.samples.petclinic.model;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PlayerRepositoryAccess {

	private PlayerRepository playerRespository;

	public PlayerRepositoryAccess(PlayerRepository playerRespository) {
		this.playerRespository = playerRespository;
		Player player1 = new Player();
		player1.setRegistrationDate(LocalDateTime.now());
		player1.setNickname("123");
		playerRespository.save(player1);
	}
}
