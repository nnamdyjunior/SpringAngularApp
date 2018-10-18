package com.nnamdyjunior.server.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nnamdyjunior.server.model.Player;
import com.nnamdyjunior.server.repository.PlayerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import sun.net.www.content.text.plain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PlayerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlayerRepository playerRepository;

    private ObjectMapper objectMapper;

    private Player ramos, isco;

    @Before
    public void setup(){
        objectMapper = new ObjectMapper();

        ramos = Player.builder()
                .name("Sergio Ramos")
                .age(32)
                .games(502)
                .goals(77)
                .build();
        isco = Player.builder()
                .name("Francisco Alacorn")
                .age(26)
                .games(210)
                .goals(51)
                .build();

        playerRepository.save(ramos);
        playerRepository.save(isco);
    }

    @Test
    public void addPlayer_savesNewPlayer() throws Exception{
        mockMvc.perform(put("/realmadrid/players/add")
                        .content(objectMapper.writeValueAsString(
                                Player.builder()
                                        .name("Sergio Ramos")
                                        .age(32)
                                        .games(502)
                                        .goals(77)
                                        .build()
                        ))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());

        assertThat(playerRepository.getPlayers()).contains(ramos);
    }

    @Test
    public void getPlayers_returnsListOfPlayers() throws Exception{
        ResultActions resultActions = mockMvc.perform(get("/realmadrid/players/get"))
                .andExpect(status().is2xxSuccessful());
        MvcResult mvcResult = resultActions.andReturn();
        assertThat(mvcResult.getResponse().getContentAsString())
                .contains(asList(objectMapper.writeValueAsString(ramos), objectMapper.writeValueAsString(isco)));
    }
}