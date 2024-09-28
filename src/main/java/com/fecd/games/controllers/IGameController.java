package com.fecd.games.controllers;

import com.fecd.games.commons.constants.APIPathVariables;
import com.fecd.games.commons.dto.CreateGameDto;
import com.fecd.games.commons.dto.UpdateGameDto;
import com.fecd.games.commons.payload.ResponseMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(APIPathVariables.V1_API + APIPathVariables.GAME_ROUTE)
public interface IGameController {
    @GetMapping
    ResponseEntity<ResponseMessage> getAllGames();

    @GetMapping("/{id}")
    ResponseEntity<ResponseMessage> getGameById(@PathVariable("id") String id);

    @PostMapping
    ResponseEntity<ResponseMessage> saveGame(@RequestBody CreateGameDto createGameDto);

    @PatchMapping("/{id}")
    ResponseEntity<ResponseMessage> updateGame(@PathVariable("id") String id, @RequestBody UpdateGameDto updateGameDto);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteGame(@PathVariable("id") String id);
}
