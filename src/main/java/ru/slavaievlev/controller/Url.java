package ru.slavaievlev.controller;

public interface Url {

    interface LoginRequest {
        String ROOT = "/login";
        String AUTHORIZATION = "/authorization";
        String REGISTRATION = "/registration";
    }

    interface UserRequest {
        String ROOT = "/users";
        String CRUD = "/user";
    }

    interface PageRequest {
        String ROOT = "/pages";
        String Place = ROOT + "/place";
    }
}
