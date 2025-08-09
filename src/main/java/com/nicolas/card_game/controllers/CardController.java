package com.nicolas.card_game.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolas.card_game.models.Card;
import com.nicolas.card_game.services.CardService;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardService service;

    @PostMapping("/drawInitialCards/{nickName}")
    public List<Card> drawInitialCards(@PathVariable String nickName){
        return service.drawInitialCards(nickName);
    }

}
