package ru.slavaievlev.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.db.model.Area;

public interface IAreaRepository extends JpaRepository<Area, Integer> {
}
