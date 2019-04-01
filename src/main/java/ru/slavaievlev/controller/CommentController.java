package ru.slavaievlev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.slavaievlev.dto.CommentDto;
import ru.slavaievlev.service.ICommentService;

@RestController
@RequestMapping(Url.CommentRequest.ROOT)
public class CommentController {

    private ICommentService commentService;

    @Autowired
    public CommentController(ICommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public String post(@RequestBody CommentDto commentDto) {
        try {
            commentService.create(commentDto);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return null;
    }
}
