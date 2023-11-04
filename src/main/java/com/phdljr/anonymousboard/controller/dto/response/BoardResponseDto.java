package com.phdljr.anonymousboard.controller.dto.response;


import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public class BoardResponseDto {
    private Long id;
    private String title;
    private String createdBy;
    private String contents;
    private LocalDateTime createdAt;
}
