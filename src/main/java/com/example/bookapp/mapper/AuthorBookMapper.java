package com.example.bookapp.mapper;

import com.example.bookapp.domain.AuthorBook;
import com.example.bookapp.dto.AuthorBookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {BookMapper.class,UserMapper.class} ,unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface AuthorBookMapper {

    AuthorBookDTO authorBookToAuthorBookDTO(AuthorBook authorBook);

    AuthorBook authorBookDTOToAuthorBook(AuthorBookDTO authorBookDTO);

}
