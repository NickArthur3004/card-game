package com.nicolas.card_game.models.TO;

import java.util.List;

public class DeckInitialTO {

    private boolean success;
    private String deck_id;
    private List<CardTO> cards;

    public DeckInitialTO() {
    }
    
    public DeckInitialTO(boolean success, String deck_id, List<CardTO> cards) {
        this.success = success;
        this.deck_id = deck_id;
        this.cards = cards;
    }
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public String getDeck_id() {
        return deck_id;
    }
    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }
    public List<CardTO> getCards() {
        return cards;
    }
    public void setCards(List<CardTO> cards) {
        this.cards = cards;
    }

    

}
