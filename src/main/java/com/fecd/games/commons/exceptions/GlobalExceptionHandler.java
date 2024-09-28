package com.fecd.games.commons.exceptions;

import com.fecd.games.commons.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {GameException.class})
    ResponseEntity<ErrorResponse> handleError(GameException gameException) {
        ErrorResponse errorResponse = new ErrorResponse.Builder()
                .status(gameException.getHttpStatus().value())
                .message(gameException.getMessage())
                .build();
        return ResponseEntity.status(gameException.getHttpStatus()).body(errorResponse);
    }
}
