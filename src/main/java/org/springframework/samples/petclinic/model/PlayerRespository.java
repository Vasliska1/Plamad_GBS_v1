package org.springframework.samples.petclinic.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PlayerRespository extends Repository<Player, Integer> {

	@Transactional(readOnly = true)
	Player findById(Integer id);

}
