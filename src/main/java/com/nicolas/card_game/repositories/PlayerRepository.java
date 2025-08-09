package com.nicolas.card_game.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nicolas.card_game.models.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    boolean existsByNickNameAndEnableIsTrue(String nickName);

    List<Player> findAllByEnableIsTrue();

    Player findByNickNameAndEnableIsTrue(String nickName);

}
