package com.example.demo.web.dto;

import com.example.demo.domain.ptext.Ptext;

import lombok.Getter;

@Getter
public class PtextResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PtextResponseDto(Ptext entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}