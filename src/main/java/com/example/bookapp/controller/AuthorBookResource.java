package com.example.bookapp.controller;

import com.example.bookapp.dto.AuthorBookDTO;
import com.example.bookapp.dto.UserDTO;
import com.example.bookapp.filter.AuthorBookFilter;
import com.example.bookapp.mapper.AuthorBookMapper;
import com.example.bookapp.service.AuthorBookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "Author and Book REST controller", tags = "authors-and-books-resource")
@RequestMapping("/api/authors-and-books")
public class AuthorBookResource {

    private final Logger log = LoggerFactory.getLogger(AuthorBookResource.class);
    private static final String ENTITY_NAME = "Author and book";

    private final AuthorBookService authorBookService;

    private AuthorBookMapper authorBookMapper;

    public AuthorBookResource(AuthorBookService authorBookService) {
        this.authorBookService = authorBookService;
    }

    @Autowired
    public void setUserMapper(AuthorBookMapper authorBookMapper) {
        this.authorBookMapper = authorBookMapper;
    }

    @ApiOperation(httpMethod = "GET", response = UserDTO.class, responseContainer = "Page",
            value = "/api/authors-and-books/authors/page", nickname = "getAllAuthorsWithBooks")
    @GetMapping(value = "/authors/page")
    public ResponseEntity<Page<AuthorBookDTO>> getAllAuthorsWithBooks(
            @PageableDefault(size = Integer.MAX_VALUE) Pageable pageable,
            AuthorBookFilter criteria) {
        log.debug("REST request to get all Authors");
        Page<AuthorBookDTO> result = authorBookService.findAllAuthorsWithPublishedBooks(criteria, pageable)
                .map(authorBookMapper::authorBookToAuthorBookDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "GET", response = UserDTO.class, responseContainer = "Page",
            value = "/api/authors-and-books/books/page", nickname = "getAllBooks")
    @GetMapping(value = "/authors-and-books/books/page")
    public ResponseEntity<Page<AuthorBookDTO>> getAllBooks(
            @PageableDefault(size = Integer.MAX_VALUE) Pageable pageable,
            AuthorBookFilter criteria) {
        log.debug("REST request to get all Authors");
        Page<AuthorBookDTO> result = authorBookService.findByCriteria(criteria, pageable)
                .map(authorBookMapper::authorBookToAuthorBookDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
