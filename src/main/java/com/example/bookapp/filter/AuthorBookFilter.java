package com.example.bookapp.filter;

import com.example.bookapp.domain.BookStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public Boolean getAuthor() {
        return isAuthor;
    }

    public void setAuthor(Boolean author) {
        isAuthor = author;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public LocalDateTime getBookPublishedFrom() {
        return bookPublishedFrom;
    }

    public void setBookPublishedFrom(LocalDateTime bookPublishedFrom) {
        this.bookPublishedFrom = bookPublishedFrom;
    }

    public LocalDateTime getBookPublishedTo() {
        return bookPublishedTo;
    }

    public void setBookPublishedTo(LocalDateTime bookPublishedTo) {
        this.bookPublishedTo = bookPublishedTo;
    }

    public LocalDateTime getAuthorCreatedFrom() {
        return authorCreatedFrom;
    }

    public void setAuthorCreatedFrom(LocalDateTime authorCreatedFrom) {
        this.authorCreatedFrom = authorCreatedFrom;
    }

    public LocalDateTime getAuthorCreatedTo() {
        return authorCreatedTo;
    }

    public void setAuthorCreatedTo(LocalDateTime authorCreatedTo) {
        this.authorCreatedTo = authorCreatedTo;
    }
}
