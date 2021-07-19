package com.example.bookapp.service;

import com.example.bookapp.domain.BookStatus;
import com.example.bookapp.repository.BookStatusRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BookStatusService {

    private final Logger log = LoggerFactory.getLogger(BookStatusService.class);

    private final BookStatusRepository bookStatusRepository;

    public BookStatusService(BookStatusRepository bookStatusRepository) {
        this.bookStatusRepository = bookStatusRepository;
    }

    /**
     * Find {@link BookStatus} by code
     *
     * @param code                            code ot the BookStatus
     * @return Book Status
     */
    public BookStatus findOneByCode(String code) {
        log.debug("Request to get Book status with code : {}", code);
        return bookStatusRepository.findByCode(code);
    }

}
