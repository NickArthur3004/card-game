package com.nicolas.card_game.services;

import java.util.List;

import com.nicolas.card_game.models.Card;

public interface CardService {

    List<Card> drawInitialCards(String nickName);
    
}