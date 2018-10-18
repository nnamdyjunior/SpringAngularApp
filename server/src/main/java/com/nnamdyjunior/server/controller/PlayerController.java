package com.nnamdyjunior.server.controller;

import com.nnamdyjunior.server.model.Player;
import com.nnamdyjunior.server.service.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realmadrid/players")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/get")
    public List<Player> getPlayers(){
        return this.playerService.getPlayers();
    }

    @PutMapping("/add")
    public void addPlayer(@RequestBody Player player){
        this.playerService.save(player);
    }
}
