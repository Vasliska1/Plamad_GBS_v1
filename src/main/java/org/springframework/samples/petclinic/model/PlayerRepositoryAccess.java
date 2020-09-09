package org.springframework.samples.petclinic.model;

import org.springframework.stereotype.Component;

@Component
public class PlayerRepositoryAccess {



	private PlayerRespository playerRespository;
	public PlayerRepositoryAccess(PlayerRespository playerRespository) {
		this.playerRespository =playerRespository;
		Player player = playerRespository.findById(1);
		System.out.println(player.toString());
	}



}
