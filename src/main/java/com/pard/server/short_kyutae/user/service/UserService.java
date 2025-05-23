package com.pard.server.short_kyutae.user.service;





import com.pard.server.short_kyutae.user.dto.UserReqDto;
import com.pard.server.short_kyutae.user.dto.UserResDto;
import com.pard.server.short_kyutae.user.entity.User;
import com.pard.server.short_kyutae.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void save(UserReqDto.CreateUser userDto) {
        User user = User.builder()
                .author(userDto.getAuthor())//저자
                .bookName(userDto.getBookName())
                .allPage(userDto.getAllPage())
                .targetPage(userDto.getTargetPage())//데일리 목표 분량
                .presentPage(userDto.getPresentPage())//읽은 페이지 수
                .build();
           userRepo.save(user);

    }

    public List<UserResDto.UserDetail> readUser() {
        return userRepo.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
    private UserResDto.UserDetail convertToDto(User user) {
        Timestamp createdAt = user.getCreatedAt();
        Timestamp updatedAt = user.getUpdatedAt();

        Timestamp uploadTime = (updatedAt != null && !updatedAt.equals(createdAt))
                ? updatedAt
                : createdAt;

        return UserResDto.UserDetail.builder()
                .bookId(user.getBookId())
                .author(user.getAuthor())
                .bookName(user.getBookName())
                .allPage(user.getAllPage())
                .targetPage(user.getTargetPage())
                .presentPage(user.getPresentPage())
                .oneLineComment(user.getOneLineComment())
                .uploadTime(uploadTime)
                .build();
    }


    public void update(Long id, UserReqDto.CreateUser req){
        User user = userRepo.findById(id).orElseThrow(RuntimeException::new);
        user.update(req.getAuthor(),
                    req.getBookName(),
                    req.getAllPage(),
                    req.getTargetPage(),
                    req.getPresentPage());
        userRepo.save(user);
    }

    public void deleteUser(Long bookId){
        userRepo.deleteById(bookId);
    }


}