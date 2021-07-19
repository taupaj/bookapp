package com.example.bookapp.controller;

import com.example.bookapp.domain.Book;
import com.example.bookapp.domain.User;
import com.example.bookapp.dto.BookDTO;
import com.example.bookapp.dto.UserDTO;
import com.example.bookapp.error.NewEntityCannotHaveIDException;
import com.example.bookapp.filter.BookFilter;
import com.example.bookapp.mapper.BookMapper;
import com.example.bookapp.service.BookService;
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
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "Books REST controller", tags = "book")
@RequestMapping("/api/book")
public class BookResource {

    private final Logger log = LoggerFactory.getLogger(BookResource.class);
    private static final String ENTITY_NAME = "Book";

    private final BookService bookService;
    private BookMapper bookMapper;

    public BookResource(BookService bookService) {
        this.bookService = bookService;
    }

    @Autowired
    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @ApiOperation(
            httpMethod = "POST",
            response = BookDTO.class,
            value = "/api/book",
            nickname = "createBook")
    @PostMapping(value = "/book")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        log.debug("REST request create Book: {}", bookDTO);
        if (bookDTO.getId() != null) {
            throw new NewEntityCannotHaveIDException(ENTITY_NAME);
        }
        Book book = bookMapper.bookDTOToBook(bookDTO);
        BookDTO result = bookMapper.bookToBookDTO(bookService.createOrUpdate(book));
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @ApiOperation(httpMethod = "GET", response = BookDTO.class, responseContainer = "Page",
            value = "/api/book/page", nickname = "getAllBooks")
    @GetMapping("/page")
    public ResponseEntity<Page<BookDTO>> getAllBooks(
            @PageableDefault(size = Integer.MAX_VALUE) Pageable pageable,
            BookFilter criteria) {
        log.debug("REST request to get all Books");
        Page<BookDTO> result = bookService.findByCriteria(criteria, pageable)
                .map(bookMapper::bookToBookDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @ApiOperation(httpMethod = "PUT", value = "/api/book/status/publish/{id}", nickname = "publishBook")
    @PutMapping(value = "/status/published/{id}")
    public ResponseEntity<Void> publishBook(@PathVariable("id") Long id) {
        log.debug("REST request to publish Book with id : {}", id);
        bookService.changeBookStatusToPublished(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
