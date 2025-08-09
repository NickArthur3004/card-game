package com.nicolas.card_game.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicolas.card_game.dto.PlayerDTO;
import com.nicolas.card_game.models.Player;
import com.nicolas.card_game.services.PlayerService;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    @Autowired
    private PlayerService service;

    @GetMapping
    public ResponseEntity<List<Player>> findAll(){
        return ResponseEntity.ok(service.findAllPlayers());
    }

    @PostMapping(value = "/create")
    public Player createPlayer(@RequestBody PlayerDTO dto){
        return service.createPlayer(dto);
    }

    @PostMapping(value = "/create/players")
    public List<Player> createListPlayers(@RequestBody List<PlayerDTO> dto){
        return service.createListPlayers(dto);
    }

    @PatchMapping(value = "/edit")
    public ResponseEntity<Player> editPlayer(@RequestBody PlayerDTO dto){
        return ResponseEntity.ok(service.editPlayer(dto));
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deletePlayer(@PathVariable Long id){
        service.deletePlayer(id);
    }

}
