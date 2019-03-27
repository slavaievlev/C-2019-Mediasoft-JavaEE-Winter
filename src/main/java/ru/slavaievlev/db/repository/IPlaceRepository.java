package ru.slavaievlev.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.db.model.Place;

public interface IPlaceRepository extends JpaRepository<Place, Long> {
}
