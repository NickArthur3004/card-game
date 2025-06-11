package com.nicolas.card_game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.card_game.models.Hand;

public interface HandRepository extends JpaRepository<Long, Hand> {

}
