package com.curlybraces.main.repository;

import com.curlybraces.main.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class UserRepository implements CrudRepository<User, UUID> {

    private final JdbcTemplate jdbcTemplate;
    private static final String SAVE_USER_QUERY = "insert into users(user_id, full_name, email, password, " +
            "registration_date, level) values(?,?,?,?,?,?)";

    @Override
    public int save(User entity) {
        return jdbcTemplate.update(SAVE_USER_QUERY, entity.getUserId(), entity.getFullName(), entity.getEmail(),
                entity.getPassword(), entity.getRegistrationDate(), entity.getLevel());
    }
}
