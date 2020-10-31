package org.springframework.samples.petclinic.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.owner.PetType;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface GameResultRepository extends Repository<GameResult, Integer> {

	@Query(nativeQuery = true,
		value = "SELECT * FROM GAME_RESULT  order by score DESC Limit 0, :counter ")
	@Transactional(readOnly = true)
	List<GameResult> getTopResults( @Param("counter") Integer counter);

	void save(GameResult gameResult);
	
}
