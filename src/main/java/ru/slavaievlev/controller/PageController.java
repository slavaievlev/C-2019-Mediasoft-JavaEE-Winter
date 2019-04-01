package ru.slavaievlev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.slavaievlev.db.model.Comment;
import ru.slavaievlev.dto.CommentDto;
import ru.slavaievlev.dto.PlaceDto;
import ru.slavaievlev.service.CommentService;
import ru.slavaievlev.service.ICommentService;
import ru.slavaievlev.service.IPlaceService;

import java.util.List;

@Controller
public class PageController {

    private IPlaceService placeService;
    private ICommentService commentService;

    @Autowired
    public PageController(IPlaceService placeService, CommentService commentService) {
        this.placeService = placeService;
        this.commentService = commentService;
    }

    @RequestMapping(value = Url.PageRequest.ROOT, method = RequestMethod.GET)
    public String hello(Model model) {

        return "hello";
    }

    @RequestMapping(value = Url.PageRequest.PLACES, method = RequestMethod.GET)
    public String places(Model model) {
        List<PlaceDto> places = placeService.getAll();
        model.addAttribute("places", places);
        return "places";
    }

    @RequestMapping(value = Url.PageRequest.PLACE, method = RequestMethod.GET)
    public String place(Model model, @RequestParam(value = "place_id") int placeId) {
        try {
            PlaceDto placeDto = placeService.getOne(new Long(placeId));
            model.addAttribute("placeDto", placeDto);

            List<CommentDto> comments = commentService.getAll(placeDto.getName());
            model.addAttribute("commentsList", comments);
        } catch (Exception ex) {
            model.addAttribute("ex", ex.getMessage());
        }

        return "place";
    }

    @RequestMapping(value = Url.PageRequest.ADD_PLACE, method = RequestMethod.GET)
    public String addPlace(Model model) {

        return "add-place";
    }
}
