package com.fecd.games.controllers.impl;

import com.fecd.games.commons.dto.CreateGameDto;
import com.fecd.games.commons.dto.UpdateGameDto;
import com.fecd.games.commons.payload.ResponseMessage;
import com.fecd.games.controllers.IGameController;
import com.fecd.games.models.entities.Game;
import com.fecd.games.services.IGameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController implements IGameController {
    private final IGameService gameService;

    private GameController(IGameService gameService) {
        this.gameService = gameService;
    }

    @Override
    public ResponseEntity<ResponseMessage> getAllGames() {
        List<Game> gamesFound = this.gameService.getAllGames();
        return ResponseEntity.ok(new ResponseMessage
                .Builder()
                .setMessage("Games fetched successfully")
                .setData(gamesFound)
                .build());
    }

    @Override
    public ResponseEntity<ResponseMessage> getGameById(String id) {
        Game gameFound = this.gameService.getGameById(id);
        return ResponseEntity.ok(new ResponseMessage
                .Builder()
                .setMessage("Game with id: " + id + " Fetched Successfully")
                .setData(gameFound)
                .build());
    }

    @Override
    public ResponseEntity<ResponseMessage> saveGame(CreateGameDto createGameDto) {
        Game game = this.gameService.saveGame(createGameDto);
        return ResponseEntity.ok(new ResponseMessage
                .Builder()
                .setMessage("Game created successful;ly")
                .setData(game)
                .build());
    }

    @Override
    public ResponseEntity<ResponseMessage> updateGame(String id, UpdateGameDto updateGameDto) {
        Game gameUpdated = this.gameService.updateGame(updateGameDto, id);
        return ResponseEntity.ok(new ResponseMessage
                .Builder()
                .setMessage("Game updated succesfully")
                .setData(gameUpdated)
                .build());
    }

    @Override
    public ResponseEntity<Void> deleteGame(String id) {
        this.gameService.deleteGame(id);
        return ResponseEntity.noContent().build();

    }
}
