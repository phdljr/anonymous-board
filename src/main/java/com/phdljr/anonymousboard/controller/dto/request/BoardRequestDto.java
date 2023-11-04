package com.phdljr.anonymousboard.controller.dto.request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BoardRequestDto {

    private String title;
    private String password;
    private String createdBy;
    private String contents;
}
