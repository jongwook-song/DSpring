package com.example.demo.web.dto;

import com.example.demo.domain.ptext.Ptext;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PtextSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    public PtextSaveRequestDto(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Ptext toEntity() {
        return Ptext.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}