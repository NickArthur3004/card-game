package com.nicolas.card_game.models.TO;

public class DeckCreateTO {

    private String success;
    private String deck_id;
    
    public DeckCreateTO() {
    }
    public DeckCreateTO(String success, String deck_id) {
        this.success = success;
        this.deck_id = deck_id;
    }
    public String getSuccess() {
        return success;
    }
    public void setSuccess(String success) {
        this.success = success;
    }
    public String getDeck_id() {
        return deck_id;
    }
    public void setDeck_id(String deck_id) {
        this.deck_id = deck_id;
    }

    

}
