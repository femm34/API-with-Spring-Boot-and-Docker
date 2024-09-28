package com.fecd.games.commons.dto;

public class ErrorResponse {
    private Integer status;
    private String message;

    public ErrorResponse() {
    }

    public ErrorResponse(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public ErrorResponse(Builder builder) {
        this.message = builder.message;
        this.status = builder.status;
    }

    public static class Builder {
        private Integer status;
        private String message;

        public ErrorResponse.Builder status(int status) {
            this.status = status;
            return this;
        }

        public ErrorResponse.Builder message(String message) {
            this.message = message;
            return this;
        }

        public ErrorResponse build() {
            return new ErrorResponse(this);
        }
    }

    public Integer getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
