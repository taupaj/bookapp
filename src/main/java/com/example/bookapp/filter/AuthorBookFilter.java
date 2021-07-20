package com.example.bookapp.filter;

import com.example.bookapp.domain.BookStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorBookFilter implements Serializable {

    private static final long serialVersionUID = -6611227068705141126L;

    private Long id;
    private Long authorId;
    private Long bookId;
    private String authorFirstName;
    private String authorLastName;
    private Boolean isAuthor;
    private String bookTitle;
    private String bookIsbn;
    private BookStatus bookStatus;
    private LocalDateTime bookPublishedFrom;
    private LocalDateTime bookPublishedTo;
    private LocalDateTime authorCreatedFrom;
    private LocalDateTime authorCreatedTo;

}
