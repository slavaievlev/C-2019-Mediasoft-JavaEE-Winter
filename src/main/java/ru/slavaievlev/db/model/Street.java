package ru.slavaievlev.db.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "street")
public class Street {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "street_sequence", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @NotNull
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;
}
