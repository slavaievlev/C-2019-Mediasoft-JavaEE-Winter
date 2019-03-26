package ru.slavaievlev.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "place")
public class Place {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "place_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @NotNull
    private String name;

    @NotNull
    private int rating;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street street;
}
