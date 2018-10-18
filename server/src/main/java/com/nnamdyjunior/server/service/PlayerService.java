package com.nnamdyjunior.server.service;

import com.nnamdyjunior.server.model.Player;
import com.nnamdyjunior.server.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return this.playerRepository.getPlayers();
    }

    public void save(Player player){
        this.playerRepository.save(player);
    }
}
