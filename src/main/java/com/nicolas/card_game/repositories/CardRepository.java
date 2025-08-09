package com.nicolas.card_game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.card_game.models.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

}
