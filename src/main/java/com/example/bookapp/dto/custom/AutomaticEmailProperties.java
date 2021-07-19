package com.example.bookapp.dto.custom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AutomaticEmailProperties implements Serializable {

    private static final long serialVersionUID = 260489710830039419L;

    private String note;

    private String emailAddress;

    private String bookIsbn;

    private String bookTitle;

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getBookIsbn() {
        return bookIsbn;
    }

    public void setBookIsbn(String bookIsbn) {
        this.bookIsbn = bookIsbn;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    @Override
    public String toString() {
        return "AutomaticEmailProperties{" +
                "note='" + note + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", bookIsbn='" + bookIsbn + '\'' +
                ", bookTitle='" + bookTitle + '\'' +
                '}';
    }
}
