package com.fecd.games.models.dao;

import com.fecd.games.models.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameDao extends JpaRepository<Game, Long> {
}
