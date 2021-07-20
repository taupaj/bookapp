package com.example.bookapp.filter;

import com.example.bookapp.dto.BookStatusDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookFilter implements Serializable {

    private static final long serialVersionUID = -1987657068705141126L;

    private Long id;
    private String title;
    private String isbn;
    private BookStatusDTO bookStatus;

}
