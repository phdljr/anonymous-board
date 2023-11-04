package com.phdljr.anonymousboard.domain;

import com.phdljr.anonymousboard.controller.dto.response.BoardResponseDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String contents;

    public void updateContents(String title, String createdBy, String contents) {
        this.title = title;
        this.createdBy = createdBy;
        this.contents = contents;
    }

    public boolean confirmPassword(String password) {
        return this.password.equals(password);
    }

    public BoardResponseDto toResponseDto() {
        return BoardResponseDto.builder()
            .id(getId())
            .title(getTitle())
            .createdBy(getCreatedBy())
            .contents(getContents())
            .createdAt(getCreatedAt())
            .build();
    }
}
