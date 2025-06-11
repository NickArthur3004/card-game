package com.nicolas.card_game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.card_game.models.Player;

public interface PlayerRepository extends JpaRepository<Long, Player> {

}
