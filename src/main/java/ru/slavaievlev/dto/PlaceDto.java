package ru.slavaievlev.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlaceDto implements Serializable {

    private long id;

    private String name;

    private int rating;

    private String cityName;

    private String areaName;

    private String streetName;
}
