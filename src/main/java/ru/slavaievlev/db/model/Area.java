package ru.slavaievlev.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "area")
public class Area {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "area_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
}
