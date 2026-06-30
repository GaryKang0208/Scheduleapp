package com.example.app.dto;

import lombok.Getter;

@Getter

public class CreateRequest {

    private String  title;
    private String contents;
    private String author;
    private String password;
}
