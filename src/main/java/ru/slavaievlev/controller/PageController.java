package ru.slavaievlev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.slavaievlev.dto.PlaceDto;
import ru.slavaievlev.service.PlaceService;

@Controller(Url.PageRequest.ROOT)
public class PageController
{

    private PlaceService placeService;

    @Autowired
    public PageController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(Model model) {

        return "hello";
    }

    @RequestMapping(value = "/places", method = RequestMethod.GET)
    public String places(Model model) {

        return "places";
    }

    @RequestMapping(value = "/place", method = RequestMethod.GET)
    public String place(Model model, @RequestParam(value = "place_id") int placeId) {
        PlaceDto placeDto;
        try {
            placeDto = placeService.getOne(new Long(placeId));
        } catch (Exception ex) {
            placeDto = new PlaceDto();
            placeDto.setName(ex.getMessage());
        }
        model.addAttribute("placeDto", placeDto);

        return "place";
    }

    @RequestMapping(value = "/add-place", method = RequestMethod.GET)
    public String addPlace(Model model) {

        return "add-place";
    }
}
