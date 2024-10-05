package com.fecd.games.models.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public Long getId() {
        return id;
    }

    public Game(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
    }

    public Game() {
    }

    public Game(Long id, String title, String description) {
        this.title = title;
        this.id = id;
        this.description = description;
    }

    public static class Builder {
        private String title;
        private String description;

        public Game.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Game.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Game build() {
            return new Game(this);
        }
    }
}
