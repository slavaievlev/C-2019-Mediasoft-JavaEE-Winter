package ru.slavaievlev.db.model;

import lombok.Getter;
import lombok.Setter;
import ru.slavaievlev.db.model.enums.CommentState;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "street")
public class Comment {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "comment_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @NotNull
    private String text;

    @NotNull
    @Column(name = "creation_date")
    private Timestamp creationDate;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private CommentState state;

    @NotNull
    @Column(name = "place_rating")
    private int placeRating;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "place_id")
    private Place place;
}
