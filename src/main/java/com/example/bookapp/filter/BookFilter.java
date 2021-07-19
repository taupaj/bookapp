package com.example.bookapp.filter;

import com.example.bookapp.dto.BookStatusDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookFilter implements Serializable {

    private static final long serialVersionUID = -1987657068705141126L;

    private Long id;
    private String title;
    private String isbn;
    private BookStatusDTO bookStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookStatusDTO getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatusDTO bookStatus) {
        this.bookStatus = bookStatus;
    }
}
