package com.example.demo.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PtextUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PtextUpdateRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}