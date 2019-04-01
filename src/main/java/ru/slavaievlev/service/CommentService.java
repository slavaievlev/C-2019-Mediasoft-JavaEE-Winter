package ru.slavaievlev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.slavaievlev.db.model.Comment;
import ru.slavaievlev.db.model.Place;
import ru.slavaievlev.db.model.User;
import ru.slavaievlev.db.model.enums.CommentState;
import ru.slavaievlev.db.repository.ICommentRepository;
import ru.slavaievlev.db.repository.IPlaceRepository;
import ru.slavaievlev.db.repository.IUserRepository;
import ru.slavaievlev.dto.CommentDto;
import ru.slavaievlev.service.mapper.CommentMapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements ICommentService{

    private ICommentRepository commentRepository;
    private IUserRepository userRepository;
    private IPlaceRepository placeRepository;

    private CommentMapper commentMapper;

    @Autowired
    public CommentService(ICommentRepository commentRepository,
                          CommentMapper commentMapper,
                          IUserRepository userRepository,
                          IPlaceRepository placeRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.placeRepository = placeRepository;

        this.commentMapper = commentMapper;
    }

    public List<CommentDto> getAll() {
        return commentMapper.commentListToCommentDtoList(commentRepository.findAll());
    }

    public List<CommentDto> getAll(String placeName) throws Exception {
        Optional<Place> findPlace = placeRepository.getByName(placeName);
        if (!findPlace.isPresent()) {
            throw new Exception("Place not found");
        }

        return commentMapper.commentListToCommentDtoList(
                commentRepository.findByPlace(findPlace.get()));
    }

    public void create(CommentDto commentDto) throws Exception {
        Comment newComment = new Comment();
        newComment.setPlaceRating(commentDto.getPlaceRating());
        newComment.setState(CommentState.VISIBLE);
        newComment.setText(commentDto.getText());
        newComment.setCreationDate(new Timestamp(System.currentTimeMillis()));

        Optional<User> findUser = userRepository.getByLogin(commentDto.getUserLogin());
        if (!findUser.isPresent()) {
            throw new Exception("User not found");
        }
        newComment.setUser(findUser.get());

        Optional<Place> findPlace = placeRepository.getByName(commentDto.getPlaceName());
        if (!findPlace.isPresent()) {
            throw new Exception("Place not found");
        }
        newComment.setPlace(findPlace.get());

        commentRepository.saveAndFlush(newComment);
    }

    public void delete(CommentDto commentDto) {
        //
    }

    public void update(CommentDto commentDto) {
        //
    }
}
