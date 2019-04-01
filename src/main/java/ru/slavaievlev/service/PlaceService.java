package ru.slavaievlev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.slavaievlev.db.model.Place;
import ru.slavaievlev.db.repository.IPlaceRepository;
import ru.slavaievlev.dto.PlaceDto;
import ru.slavaievlev.service.mapper.PlaceMapper;

import java.util.List;
import java.util.Optional;

@Service
public class PlaceService implements IPlaceService{

    private IPlaceRepository placeRepository;

    private PlaceMapper placeMapper;

    @Autowired
    public PlaceService(IPlaceRepository placeRepository, PlaceMapper placeMapper) {
        this.placeRepository = placeRepository;
        this.placeMapper = placeMapper;
    }

    public void create(PlaceDto placeDto) {
        //
    }

    public PlaceDto getOne(Long id) throws Exception{
        Optional<Place> place = placeRepository.getById(id);
        if (!place.isPresent()) {
            throw new Exception("Place not found");
        }

        return placeMapper.placeToPlaceDto(place.get());
    }

    public List<PlaceDto> getAll() {
        List<Place> placeList = placeRepository.findAll();
        return placeMapper.placeListToPlaceDtoList(placeList);
    }

    public void update(PlaceDto placeDto) {
        //
    }

    public void delete(PlaceDto placeDto) {
        //
    }
}
