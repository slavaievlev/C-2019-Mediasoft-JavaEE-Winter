package ru.slavaievlev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.slavaievlev.dto.UserDto;
import ru.slavaievlev.service.UserService;

@RestController
@RequestMapping(Url.LoginRequest.ROOT)
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping(path = Url.LoginRequest.AUTHORIZATION)
    public String authorization(@RequestBody UserDto userDto)
    {
        System.out.println("Получили данные!");
        try {
            userService.registration(userDto);
            return null;
        } catch (Exception ex) {
            return ex.getMessage(); // TODO после тестов убрать.
        }
    }

    @PutMapping(path = Url.LoginRequest.REGISTRATION)
    public String registration(@RequestBody UserDto userDto)
    {
        try {
            userService.registration(userDto);
            return null;
        } catch (Exception ex) {
            return ex.getMessage(); // TODO после тестов убрать.
        }
    }
}
