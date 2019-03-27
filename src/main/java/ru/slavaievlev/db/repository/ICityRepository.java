package ru.slavaievlev.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.db.model.City;

import java.util.Optional;

public interface ICityRepository extends JpaRepository<City, Long> {

    Optional<City> getByName(String name);
}
