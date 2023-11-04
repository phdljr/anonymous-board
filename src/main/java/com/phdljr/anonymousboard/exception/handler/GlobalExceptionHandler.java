package com.phdljr.anonymousboard.exception.handler;

import com.phdljr.anonymousboard.exception.NotFoundBoardException;
import com.phdljr.anonymousboard.exception.WrongPasswordException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundBoardException.class, WrongPasswordException.class})
    public ResponseEntity<String> handleClientException(Exception exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }
}
