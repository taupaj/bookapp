package com.example.bookapp.mapper;

import com.example.bookapp.domain.Book;
import com.example.bookapp.domain.BookStatus;
import com.example.bookapp.dto.BookDTO;
import com.example.bookapp.dto.BookStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@Component
public interface BookStatusMapper {

    BookStatusDTO bookStatusToBookStatusDTO(BookStatus bookStatus);

    BookStatus bookStatusDTOToBookStatus(BookStatusDTO bookStatusDTO);

}
