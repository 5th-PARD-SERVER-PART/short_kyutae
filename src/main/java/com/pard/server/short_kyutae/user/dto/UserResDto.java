package com.pard.server.short_kyutae.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;


public class UserResDto {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor

    public static class UserDetail {
        private Long bookId;
        private String author;//저자

        private String bookName;//책 제목

        private int allPage;//책 전체 페이지
        private int targetPage;//데일리 목표 분량
        private int presentPage;//읽은 페이지 수

        private String oneLineComment;//한줄 평

        private Timestamp uploadTime;
    }
}
