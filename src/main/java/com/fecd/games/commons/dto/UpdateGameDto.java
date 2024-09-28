package com.fecd.games.commons.dto;

public class UpdateGameDto {
    private String title;
    private String description;

    public UpdateGameDto(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
    }

    public UpdateGameDto() {
    }

    public UpdateGameDto(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static class Builder {
        private String title;
        private String description;

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public UpdateGameDto build() {
            return new UpdateGameDto(this);
        }
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}