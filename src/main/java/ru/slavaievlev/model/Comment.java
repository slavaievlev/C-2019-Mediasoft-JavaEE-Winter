package ru.slavaievlev.model;

import lombok.Getter;
import lombok.Setter;
import ru.slavaievlev.model.enums.CommentState;

import java.sql.Timestamp;

@Getter
@Setter
public class Comment {

    private long id;

    private String text;

    private Timestamp creationDate;

    private CommentState state;

    private int placeRating;

    private long userId;

    private long placeId;
}
