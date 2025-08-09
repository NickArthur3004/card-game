package com.nicolas.card_game.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String suit;

    // Renomeado de 'value' para 'cardValue'
    @Column(name = "card_value")
    private String cardValue;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Card() {
    }
    
    public Card(String code, String cardValue, String suit) {
        this.code = code;
        this.cardValue = cardValue;
        this.suit = suit;
    }

    public Card(String code, String cardValue, String suit, Player player) {
        this.code = code;
        this.cardValue = cardValue;
        this.suit = suit;
        this.player = player;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getSuit() {
        return suit;
    }
    public void setSuit(String suit) {
        this.suit = suit;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getCardValue() {
        return cardValue;
    }

    public void setCardValue(String cardValue) {
        this.cardValue = cardValue;
    }
    
}
