package com.phdljr.anonymousboard.exception.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class ExceptionResponseDto {
    private int status;
    private String error;
    private String message;
}
