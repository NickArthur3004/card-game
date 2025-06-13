package com.nicolas.card_game.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlayerAlreadyExistException extends RuntimeException{
    public PlayerAlreadyExistException(String messsage){
        super(messsage);
    }
}
