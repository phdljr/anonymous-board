package com.phdljr.anonymousboard.exception.type;

import com.phdljr.anonymousboard.exception.dto.ExceptionResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum CustomException {
    WRONG_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다."),
    NOT_FOUND_BOARD(HttpStatus.NOT_FOUND, "해당 게시판이 존재하지 않습니다.");

    private final HttpStatus httpStatus;
    private final String message;

    public ExceptionResponseDto toDto() {
        return ExceptionResponseDto.builder()
            .status(httpStatus.value())
            .error(httpStatus.name())
            .message(message)
            .build();
    }
}
