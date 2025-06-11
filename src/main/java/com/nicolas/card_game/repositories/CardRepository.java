package com.nicolas.card_game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nicolas.card_game.models.Card;

public interface CardRepository extends JpaRepository<Card, String> {

}
