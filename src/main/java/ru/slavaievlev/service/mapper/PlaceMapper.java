package ru.slavaievlev.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import ru.slavaievlev.db.model.Place;
import ru.slavaievlev.dto.PlaceDto;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface PlaceMapper {

    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="name", source="name"),
            @Mapping(target="rating", source="rating"),
            @Mapping(target="cityName", source="city.name"),
            @Mapping(target="areaName", source="area.name"),
            @Mapping(target="streetName", source="street.name")
    })
    PlaceDto placeToPlaceDto(Place place);

    List<PlaceDto> placeListToPlaceDtoList(List<Place> placeList);
}
