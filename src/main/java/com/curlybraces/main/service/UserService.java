package com.curlybraces.main.service;

import com.curlybraces.main.domain.User;
import com.curlybraces.main.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public int saveUser(User user) {
        return repository.save(user);
    }
}
