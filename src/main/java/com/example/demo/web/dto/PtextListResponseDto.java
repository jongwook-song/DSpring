package com.example.demo.web.dto;

import lombok.Getter;

import java.time.LocalDateTime;

import com.example.demo.domain.ptext.Ptext;

@Getter
public class PtextListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public PtextListResponseDto(Ptext entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}