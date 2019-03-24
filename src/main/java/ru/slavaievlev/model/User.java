package ru.slavaievlev.model;

import lombok.Getter;
import lombok.Setter;
import ru.slavaievlev.model.enums.Role;
import ru.slavaievlev.model.enums.UserState;

@Getter
@Setter
public class User {

    public User() {

    }

    public User(String login) {
        this.login = login;
    }

    private long id;

    private String login;

    private String password;

    private String lastName;

    private String firstName;

    private UserState state;

    private Role role;

    private String cityId;
}
