package com.example.bookapp.repository;

import com.example.bookapp.domain.Book;
import com.example.bookapp.domain.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long>, JpaSpecificationExecutor<Book> {

    List<Book> findAllByBookStatusAndPublishedAtAfter(BookStatus bookStatus, LocalDate lastDateCronJob);
}
