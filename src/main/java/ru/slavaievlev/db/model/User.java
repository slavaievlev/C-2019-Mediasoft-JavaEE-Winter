package ru.slavaievlev.db.model;

import lombok.Getter;
import lombok.Setter;
import ru.slavaievlev.db.model.enums.Role;
import ru.slavaievlev.db.model.enums.UserState;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "user")
public class User {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "user_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @NotNull
    private String login;

    @NotNull
    private String password;

    @NotNull
    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private UserState state;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
