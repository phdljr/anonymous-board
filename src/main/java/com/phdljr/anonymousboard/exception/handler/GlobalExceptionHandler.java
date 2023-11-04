package com.phdljr.anonymousboard.exception.handler;

import com.phdljr.anonymousboard.exception.dto.ExceptionResponseDto;
import com.phdljr.anonymousboard.exception.type.CustomException;
import com.phdljr.anonymousboard.exception.type.NotFoundBoardException;
import com.phdljr.anonymousboard.exception.type.WrongPasswordException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<ExceptionResponseDto> handleWrongPasswordException() {
        return ResponseEntity.badRequest().body(CustomException.WRONG_PASSWORD.toDto());
    }

    @ExceptionHandler(NotFoundBoardException.class)
    public ResponseEntity<ExceptionResponseDto> handleNotFoundBoardException() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(CustomException.NOT_FOUND_BOARD.toDto());
    }
}
