package com.nicolas.card_game.models.TO;

public class CardTO {

    private String code;
    private String value;
    private String suit;

    public CardTO() {
    }

    
    public CardTO(String code, String value, String suit) {
        this.code = code;
        this.value = value;
        this.suit = suit;
    }


    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    

}
