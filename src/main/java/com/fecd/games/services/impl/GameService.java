package com.fecd.games.services.impl;

import com.fecd.games.commons.dto.CreateGameDto;
import com.fecd.games.commons.dto.UpdateGameDto;
import com.fecd.games.commons.exceptions.GameException;
import com.fecd.games.models.dao.GameDao;
import com.fecd.games.models.entities.Game;
import com.fecd.games.models.mappers.GameMapper;
import com.fecd.games.services.IGameService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService implements IGameService {
    // dependency injection
    private final GameDao gameDao; // immutable, perfect for dependency injection pattern

    public GameService(GameDao gameDao) {
        this.gameDao = gameDao;
    }

    // Here the CRUD methods begin
    @Override
    public List<Game> getAllGames() {
        return gameDao.findAll();
    }

    @Override
    public Game getGameById(String id) {
        return this.gameDao.findById(Long.valueOf(id)).orElseThrow(() -> new GameException(HttpStatus.NOT_FOUND, "Error fetching the game"));
    }

    @Override
    public Game saveGame(CreateGameDto createGameDto) {
        return this.gameDao.save(GameMapper.toEntity(createGameDto));
    }


    @Override
    public Game updateGame(UpdateGameDto updateGameDto, String id) {
        if (!this.gameExists(id)) {
            throw new GameException(HttpStatus.NOT_FOUND, "Cannot update the game because it does not exist: ID " + id);
        }
        return Optional.of(updateGameDto).map(gameUpdate -> {
            Game game = this.getGameById(id);
            return GameMapper.toEntity(gameUpdate, game);
        }).map(gameDao::save).orElseThrow(() -> new GameException(HttpStatus.BAD_REQUEST, "Error updating the game"));
    }

    @Override
    public Boolean gameExists(String id) {
        return this.gameDao.existsById(Long.valueOf(id));
    }

    @Override
    public void deleteGame(String id) {
        if (!this.gameExists(id)) {
            throw new GameException(HttpStatus.NOT_FOUND, "Cannot delete the game because it doesn't exist: ID " + id);
        }
        try {
            this.gameDao.deleteById(Long.valueOf(id));
        } catch (EmptyResultDataAccessException e) {
            throw new GameException(HttpStatus.NOT_FOUND, "The game has already been deleted: ID " + id);
        } catch (DataIntegrityViolationException e) {
            throw new GameException(HttpStatus.CONFLICT, "Cannot delete the game due to dependencies: ID " + id);
        } catch (Exception e) {
            throw new GameException(HttpStatus.INTERNAL_SERVER_ERROR, "An error occurred while trying to delete the game: " + e.getMessage());
        }

    }
}
