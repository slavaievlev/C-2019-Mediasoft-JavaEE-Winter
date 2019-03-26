package ru.slavaievlev.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private long id;
    private String login;
    private String password;
    private String lastName;
    private String firstName;
    private String stateName;
    private String roleName;
    private String cityName;
}
