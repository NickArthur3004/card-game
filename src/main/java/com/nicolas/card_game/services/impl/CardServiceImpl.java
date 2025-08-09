package com.nicolas.card_game.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nicolas.card_game.exceptions.PlayerNotFoundException;
import com.nicolas.card_game.models.Card;
import com.nicolas.card_game.models.Player;
import com.nicolas.card_game.models.TO.DeckCreateTO;
import com.nicolas.card_game.models.TO.DeckInitialTO;
import com.nicolas.card_game.repositories.CardRepository;
import com.nicolas.card_game.repositories.PlayerRepository;
import com.nicolas.card_game.services.CardService;

@Service
public class CardServiceImpl implements CardService{

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private CardRepository cardRepository;

    private final WebClient webClient;

    public CardServiceImpl(WebClient webClient){
        this.webClient = webClient;
    }

    @Override
    public List<Card> drawInitialCards(String nickName) {

        try {

            Player player = playerExist(nickName);
            return cardRepository.saveAll(drawCards(player));
            
        } catch (PlayerNotFoundException e) {
            throw new PlayerNotFoundException(e.getMessage());
        }
    }

    public Player playerExist(String nickName){
        Player player = playerRepository.findByNickNameAndEnableIsTrue(nickName);
        if(player == null){
            throw new PlayerNotFoundException(nickName + " Not Found!");
        }
        return player;
    }

    public List<Card> drawCards(Player player) {

        List<Card> cards = new ArrayList<>();
       
        DeckCreateTO createDeckTO = sendGetAPI("https://deckofcardsapi.com/api/deck/new/shuffle/?deck_count=1",DeckCreateTO.class);
        DeckInitialTO deckInitialTO = sendGetAPI("https://deckofcardsapi.com/api/deck/"+ createDeckTO.getDeck_id() +"/draw/?count=5",DeckInitialTO.class);    

        deckInitialTO.getCards().stream().forEach(c -> {
                                                    cards.add(new Card(c.getCode(), c.getValue(), c.getSuit(), player)); 
                                                });
        return cards;
    }

    public <T> T sendGetAPI(String url, Class<T> responseType) {
    return webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(responseType)
                    .block();
    }

}
