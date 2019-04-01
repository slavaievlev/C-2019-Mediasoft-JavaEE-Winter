package ru.slavaievlev.service;

import ru.slavaievlev.dto.CommentDto;

import java.util.List;

public interface ICommentService {

    List<CommentDto> getAll();

    void create(CommentDto commentDto) throws Exception;

    List<CommentDto> getAll(String placeName) throws Exception;

    void delete(CommentDto commentDto);

    void update(CommentDto commentDto);
}
