package ru.slavaievlev.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.slavaievlev.db.model.enums.CommentState;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto implements Serializable {

    private long id;

    private String text;

    private Timestamp creationDate;

    private CommentState state;

    private int placeRating;

    private String userLogin;

    private String placeName;
}
