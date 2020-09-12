package org.springframework.samples.petclinic.model;

import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface PlayerRespository extends Repository<Player, Integer> {

	@Transactional(readOnly = true)
	Player findById(Integer id);

	void save(Player player);
}
