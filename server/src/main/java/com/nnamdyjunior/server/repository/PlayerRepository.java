package com.nnamdyjunior.server.repository;

import com.nnamdyjunior.server.model.Player;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PlayerRepository {
    private List<Player> players;

    public PlayerRepository() {
        this.players = new ArrayList<>();
    }

    public List<Player> getPlayers(){
        return players;
    }

    public void save(Player player){
        players.add(player);
    }
}
