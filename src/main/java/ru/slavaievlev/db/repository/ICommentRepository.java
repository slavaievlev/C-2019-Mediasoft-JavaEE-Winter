package ru.slavaievlev.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.slavaievlev.db.model.Comment;

public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
