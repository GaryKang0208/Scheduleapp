package com.example.app.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass  // 공통필드에서 상속받기위해 사용하는 어노테이션
@EntityListeners(AuditingEntityListener.class)  // 저장/수정을 감지해 아내 날짜 필드를 자동으로 채워준다

public abstract class BaseEntity {

    @CreatedDate // 처음 생산시 기록
    @Column(updatable = false)
    private LocalDateTime createdAt;


    @LastModifiedDate // 수정시 기록
    @Column
    private LocalDateTime modifiedAt;
}
