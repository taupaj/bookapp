package com.example.bookapp.service;

import com.example.bookapp.domain.AuthorBook;
import com.example.bookapp.filter.AuthorBookFilter;
import com.example.bookapp.repository.AuthorBookRepository;
import com.example.bookapp.repository.BookStatusRepository;
import com.example.bookapp.spacification.AuthorBookSpecification;
import com.example.bookapp.utils.BookStatuses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AuthorBookService {

    private static final String ENTITY_NAME = "User";

    private final Logger log = LoggerFactory.getLogger(AuthorBookService.class);

    private final AuthorBookRepository authorBookRepository;
    private final BookStatusRepository bookStatusRepository;

    public AuthorBookService(AuthorBookRepository authorBookRepository,
                             BookStatusRepository bookStatusRepository) {
        this.authorBookRepository = authorBookRepository;
        this.bookStatusRepository = bookStatusRepository;
    }

    /**
     * Return a {@link Page} of {@link AuthorBook} which matches the criteria from the database
     *
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AuthorBook> findAllAuthorsWithPublishedBooks(AuthorBookFilter criteria, Pageable page) {
        prepareCriteria(criteria);
        log.debug("find by criteria : {}", criteria);
        return authorBookRepository.getAllAuthorsWithPublishedBooks(criteria,page);
    }

    /**
     * Return a {@link Page} of {@link AuthorBook} which matches the criteria from the database
     *
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<AuthorBook>findByCriteria(AuthorBookFilter criteria, Pageable page) {
        prepareCriteria(criteria);
        log.debug("find by criteria : {}", criteria);
        final Specification<AuthorBook> specification = AuthorBookSpecification.of(criteria);
        return authorBookRepository.findAll(specification,page);
    }

    private void prepareCriteria(AuthorBookFilter authorBookFilter) {
        authorBookFilter.setBookStatus(bookStatusRepository.findByCode(BookStatuses.PUBLISHED_CODE));
        authorBookFilter.setAuthor(Boolean.TRUE);
    }
}
