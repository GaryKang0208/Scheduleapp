package com.example.app.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity   // db 와 연결되는 겍체라는 아노테이션
@Table(name = "schedules")   // 테이블이랑 schedules
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 외부에서 접근 못하게 막는 아노테이션

public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false,columnDefinition = "TEXT")
    private String contents;

    @Column(nullable = false, length = 100)
    private String author;

    @Column(nullable = false, length = 255)
    private String password;


    public Schedule(String title, String contents, String author, String password){
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.password = password;
    }

    public void update(String title, String contents, String author, String password){
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.password = password;
    }

}
