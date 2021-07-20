package com.example.bookapp.filter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserFilter implements Serializable {

    private static final long serialVersionUID = -6611227068705141126L;

    private Long id;
    private List<Long> ids;
    private String firstName;
    private String lastName;
    private String username;
    private Boolean isAuthor;
}
