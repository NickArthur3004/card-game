package com.nicolas.card_game.services;


import java.util.List;

import com.nicolas.card_game.dto.PlayerDTO;
import com.nicolas.card_game.models.Player;

public interface PlayerService {

    Player createPlayer(PlayerDTO dto);

    List<Player> findAllPlayers();
}