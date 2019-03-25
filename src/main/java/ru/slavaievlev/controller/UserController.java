package ru.slavaievlev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.slavaievlev.db.model.User;
import ru.slavaievlev.service.UserService;

@Controller
@RequestMapping(Url.UserRequest.ROOT)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(value = "/list")
//    public @ResponseBody
//    List<User> getAllUsers() {
//        return userService.getAllUsers();
//    }
}
