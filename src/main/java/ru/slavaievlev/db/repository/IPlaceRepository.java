package ru.slavaievlev.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.db.model.Place;

import java.util.Optional;

public interface IPlaceRepository extends JpaRepository<Place, Long> {

    Optional<Place> getById(Long id);
    Optional<Place> getByName(String name);
}
