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

}
