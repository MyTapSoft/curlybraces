package com.curlybraces.main.controller;

import com.curlybraces.main.domain.User;
import com.curlybraces.main.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

   @GetMapping("/test")
    public int saveUser() {
       User user = User.builder()
               .userId(UUID.randomUUID())
               .email("random@mail.com")
               .fullName("John Dow")
               .level(1)
               .password("sdsdfdsf")
               .registrationDate(LocalDateTime.now())
               .build();
       return userService.saveUser(user);

    }
}
