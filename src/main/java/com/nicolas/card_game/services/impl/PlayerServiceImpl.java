package com.nicolas.card_game.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nicolas.card_game.dto.PlayerDTO;
import com.nicolas.card_game.models.Player;
import com.nicolas.card_game.repositories.PlayerRepository;
import com.nicolas.card_game.services.PlayerService;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepository repository;

    @Override
    public Player createPlayer(PlayerDTO dto) {
        Player player = new Player(dto.getNickName(), dto.isOnline());
        return repository.save(player);
    }

    @Override
    public List<Player> findAllPlayers() {
        return repository.findAll();
    }

}
