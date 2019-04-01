package ru.slavaievlev.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;
import ru.slavaievlev.db.model.Comment;
import ru.slavaievlev.dto.CommentDto;

import java.util.List;

@Mapper(componentModel = "spring")
@Component
public interface CommentMapper {

    @Mappings({
            @Mapping(target="id", source="id"),
            @Mapping(target="text", source="text"),
            @Mapping(target="creationDate", source="creationDate"),
            @Mapping(target="state", source="state"),
            @Mapping(target="placeRating", source="placeRating"),
            @Mapping(target="userLogin", source="user.login"),
            @Mapping(target="placeName", source="place.name")
    })
    CommentDto commentToCommentDto(Comment comment);

    List<CommentDto> commentListToCommentDtoList(List<Comment> commentList);
}
