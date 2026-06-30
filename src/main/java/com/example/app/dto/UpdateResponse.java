package com.example.app.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class UpdateResponse {
    private final Long id;
    private final String title;
    private final String author;
    private final String contents;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;
}
