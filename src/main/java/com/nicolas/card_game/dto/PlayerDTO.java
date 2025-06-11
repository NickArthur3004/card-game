package com.nicolas.card_game.dto;

public class PlayerDTO {

    private String nickName;
    private boolean online;

    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public boolean isOnline() {
        return online;
    }
    public void setOnline(boolean online) {
        this.online = online;
    }

}
