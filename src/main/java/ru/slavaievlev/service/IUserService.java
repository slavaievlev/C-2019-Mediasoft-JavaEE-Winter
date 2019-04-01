package ru.slavaievlev.service;

import ru.slavaievlev.dto.UserDto;

public interface IUserService {

    void authorization(UserDto userDto) throws Exception;

    void registration(UserDto userDto) throws Exception;
}
