package com.example.bookapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookDTO implements Serializable {

    private static final long serialVersionUID = -1313135206713526718L;

    private Long id;
    private String title;
    private String isbn;
    private BookStatusDTO bookStatusDTO;
    private LocalDateTime publishedAt;

}
