package com.example.bookapp.repository;

import com.example.bookapp.domain.BookStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface BookStatusRepository extends
        JpaRepository<BookStatus, Long>, JpaSpecificationExecutor<BookStatus> {

    BookStatus findByCode(String code);
}
