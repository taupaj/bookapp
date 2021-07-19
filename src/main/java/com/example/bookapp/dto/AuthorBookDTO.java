package com.example.bookapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorBookDTO implements Serializable {

    private static final long serialVersionUID = -1818415206713526718L;

    private Long id;
    private UserDTO author;
    private BookDTO book;
}
