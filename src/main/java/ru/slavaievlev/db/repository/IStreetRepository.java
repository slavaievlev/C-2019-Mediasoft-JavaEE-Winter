package ru.slavaievlev.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.db.model.Street;

public interface IStreetRepository extends JpaRepository<Street, Integer> {
}
