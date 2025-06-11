package com.nicolas.card_game.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {

    @Id
    private String code;
    private String image;
    private String value;
    private String suit;

    @ManyToOne
    @JoinColumn(name = "hand_id")
    private Hand hand;

    public Card() {
    }
    
    public Card(String code, String image, String value, String suit) {
        this.code = code;
        this.image = image;
        this.value = value;
        this.suit = suit;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
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

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }
    
}
