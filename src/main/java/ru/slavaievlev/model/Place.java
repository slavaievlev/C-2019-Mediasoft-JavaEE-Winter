package ru.slavaievlev.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Place {

    private long id;

    private String name;

    private int rating;

    private long cityId;

    private long areaId;

    private long streetId;
}
