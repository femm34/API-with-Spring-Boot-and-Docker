package com.fecd.games.commons.dto;

public class CreateGameDto {
    private String title;
    private String description;

    public CreateGameDto(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
    }

    public CreateGameDto() {
    }

    public CreateGameDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static class Builder {
        private String title;
        private String description;

        public CreateGameDto.Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public CreateGameDto.Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public CreateGameDto build() {
            return new CreateGameDto(this);
        }

    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
