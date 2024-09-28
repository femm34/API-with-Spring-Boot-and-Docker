package com.fecd.games.services;

import com.fecd.games.commons.dto.CreateGameDto;
import com.fecd.games.commons.dto.UpdateGameDto;
import com.fecd.games.models.entities.Game;

import java.util.List;

public interface IGameService {
    List<Game> getAllGames();

    Game getGameById(String id);

    Game saveGame(CreateGameDto createGameDto);

    Game updateGame(UpdateGameDto updateGameDto, String id);

    Boolean gameExists(String id);

    void deleteGame(String id);
}
