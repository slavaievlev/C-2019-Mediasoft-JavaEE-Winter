package ru.slavaievlev.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.db.model.Comment;
import ru.slavaievlev.db.model.Place;

import java.util.List;

public interface ICommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByPlace(Place place);
}
