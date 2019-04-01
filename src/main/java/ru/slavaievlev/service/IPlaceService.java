package ru.slavaievlev.service;

import ru.slavaievlev.dto.PlaceDto;

import java.util.List;

public interface IPlaceService {

    void create(PlaceDto placeDto);

    PlaceDto getOne(Long id) throws Exception;

    List<PlaceDto> getAll();

    void update(PlaceDto placeDto);

    void delete(PlaceDto placeDto);
}
