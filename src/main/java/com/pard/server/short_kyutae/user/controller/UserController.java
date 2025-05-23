package com.pard.server.short_kyutae.user.controller;




import com.pard.server.short_kyutae.user.dto.UserReqDto;
import com.pard.server.short_kyutae.user.dto.UserResDto;
import com.pard.server.short_kyutae.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/bookList")
public class UserController {

    private final UserService userService;


    @GetMapping("")
    public ResponseEntity<List<UserResDto.UserDetail>> findAll() {
        List<UserResDto.UserDetail> users = userService.readUser();
        if (users.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204
        }
        return ResponseEntity.ok(users); // 200
    }




    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody UserReqDto.CreateUser req) {
        userService.save(req);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{bookId}")
    public ResponseEntity<Void> update(@PathVariable Long bookId, @RequestBody UserReqDto.CreateUser req) {
        userService.update(bookId, req);
        return ResponseEntity.ok().build(); // 200 OK 응답
    }


    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long bookId) {
        userService.deleteUser(bookId);
        return ResponseEntity.noContent().build();
    }


}



