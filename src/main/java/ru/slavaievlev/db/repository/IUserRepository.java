package ru.slavaievlev.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.db.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
