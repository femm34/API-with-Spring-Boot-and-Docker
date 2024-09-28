package com.fecd.games.models.mappers;

import com.fecd.games.commons.dto.CreateGameDto;
import com.fecd.games.commons.dto.UpdateGameDto;
import com.fecd.games.models.entities.Game;

public class GameMapper {
    public static Game toEntity(CreateGameDto createGameDto) {
        return new Game.Builder()
                .setTitle(createGameDto.getTitle())
                .setDescription(createGameDto.getDescription())
                .build();
    }

    public static CreateGameDto toDto(Game game) {
        return new CreateGameDto.Builder()
                .setTitle(game.getTitle())
                .setDescription(game.getDescription())
                .build();
    }

    public static Game toEntity(UpdateGameDto updateGameDto, Game gameToUpdate) {
        if (updateGameDto.getTitle() != null) {
            gameToUpdate.setTitle(updateGameDto.getTitle());
        }
        if (updateGameDto.getDescription() != null) {
            gameToUpdate.setDescription(updateGameDto.getDescription());
        }
        return gameToUpdate;
    }

}
