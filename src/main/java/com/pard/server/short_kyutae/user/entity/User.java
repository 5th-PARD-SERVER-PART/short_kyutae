package com.pard.server.short_kyutae.user.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    private String author;//저자

    private String bookName;//책 제목

    private int allPage;//책 전체 페이지
    private int targetPage;//데일리 목표 분량
    private int presentPage;//읽은 페이지 수

    private String oneLineComment;//한줄 평

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    public void update(String author, String bookName, int allPage, int targetPage, int presentPage) {
        this.author = author;
        this.bookName = bookName;
        this.allPage = allPage;
        this.targetPage = targetPage;
        this.presentPage = presentPage;
    }


}
