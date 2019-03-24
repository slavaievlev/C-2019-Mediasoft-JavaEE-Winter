package ru.slavaievlev.repository;

import org.springframework.stereotype.Repository;
import ru.slavaievlev.model.User;

import java.util.Arrays;
import java.util.List;

@Repository
public class UserDao {

    private List<User> users = Arrays.asList(new User("newuSER"), new User("newuSER222"));

    public List<User> getAllUsers() {
        return users;
    }
}
