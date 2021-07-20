package com.example.bookapp.mapper;

import com.example.bookapp.domain.Book;
import com.example.bookapp.dto.BookDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", uses = {BookStatusMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface BookMapper {

    BookDTO bookToBookDTO(Book book);

    Book bookDTOToBook(BookDTO bookDTO);

}
