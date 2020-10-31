package org.springframework.samples.petclinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Table(name = "game_result")
public class GameResult  extends BaseEntity {


	@Column(name = "date")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime date;

	@Column(name = "score")
	@NotEmpty
	private int score;

	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;

	public LocalDateTime getDate() {
		return date;
	}

	public int getScore() {
		return score;
	}

	public Player getPlayer() {
		return player;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
}
