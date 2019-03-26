package ru.slavaievlev.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.db.model.User;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    Optional<User> getByLogin(String login);
}
