package com.nicolas.card_game.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.nicolas.card_game.dto.PlayerDTO;
import com.nicolas.card_game.exceptions.IncorrectDataException;
import com.nicolas.card_game.exceptions.PlayerAlreadyExistException;
import com.nicolas.card_game.exceptions.PlayerNotFoundException;
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
        try {
            playerAlreadyExist(dto.getNickName());
        } catch (PlayerAlreadyExistException p) {
            throw new PlayerAlreadyExistException(p.getMessage());
        }
        return repository.save(player);
    }

    @Override
    public List<Player> findAllPlayers() {
        try{
            List<Player> players = repository.findAllByEnableIsTrue();

            if(players.isEmpty()){
                throw new PlayerNotFoundException("Players not found");
            }
            return players;
            
        }catch(DataAccessException e){
            throw new PlayerNotFoundException(e.getMessage());
        } 
    }

    @Override
    public List<Player> createListPlayers(List<PlayerDTO> dto) {
        List<Player> players = new ArrayList<>();

        try{
            if(dto.isEmpty()){
                throw new IncorrectDataException("New players is empty!");
            }

            dto.stream().forEach(d -> {
                playerAlreadyExist(d.getNickName());

                Player p = new Player(d.getNickName(), d.isOnline());
                players.add(p);
            });

        }catch(IncorrectDataException i){
            throw new IncorrectDataException(i.getMessage());
        }catch(PlayerAlreadyExistException p){
            throw new PlayerAlreadyExistException(p.getMessage());
        }

        return repository.saveAll(players);
    }

    @Override
    public Player editPlayer(PlayerDTO dto) {

        try {
            Player p = repository.findById(dto.getId())
                .orElseThrow(() -> new PlayerNotFoundException("Player id not found!"));

            
            if(dto.getNickName() != null){
                playerAlreadyExist(dto.getNickName());
            }

            p.setNickName(dto.getNickName() != null ? dto.getNickName() : p.getNickName());
            p.setOnline(dto.isOnline());
            p.setEnable(dto.isEnable());

            return repository.saveAndFlush(p);

        } catch (PlayerNotFoundException e) {
            throw new PlayerNotFoundException(e.getMessage());
        } catch(PlayerAlreadyExistException p){
            throw new PlayerAlreadyExistException(p.getMessage());
        }

    }

    @Override
    public void deletePlayer(Long id) {
        Player p = repository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player id not found!"));
        
        repository.deleteById(id);
    }


    public void playerAlreadyExist(String nickName){
        if (repository.existsByNickNameAndEnableIsTrue(nickName)) {
            throw new PlayerAlreadyExistException("This player " + nickName + " already exist! please try another NickName.");
        }
    }

    public void playerIsEnable(boolean enable){
        if(enable == true){

        }
    }

    

}
