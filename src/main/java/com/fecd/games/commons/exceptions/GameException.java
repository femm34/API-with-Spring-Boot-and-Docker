package com.fecd.games.commons.exceptions;

import org.springframework.http.HttpStatus;

public class GameException extends RuntimeException {
    private final HttpStatus httpStatus;

    public GameException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
