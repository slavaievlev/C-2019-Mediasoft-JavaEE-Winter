package ru.slavaievlev.controller;

public interface Url {

    interface LoginRequest {
        String ROOT = "/login";
        String AUTHORIZATION = "/authorization";
        String REGISTRATION = "/registration";
    }

    interface PageRequest {
        String ROOT = "/";
        String PLACES = "/places";
        String PLACE = PLACES + "/place";
        String ADD_PLACE = PLACES + "/add-place";
    }

    interface CommentRequest {
        String ROOT = "/comments";
    }
}
