package com.example.bookapp.service;

import com.example.bookapp.domain.Book;
import com.example.bookapp.domain.User;
import com.example.bookapp.dto.custom.AutomaticEmailProperties;
import com.example.bookapp.error.EntityDoesNotExistException;
import com.example.bookapp.filter.BookFilter;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.repository.BookStatusRepository;
import com.example.bookapp.spacification.BookSpecification;
import com.example.bookapp.utils.BookStatuses;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

@Service
@Transactional
public class BookService {

    private static final String ENTITY_NAME = "Book";

    private final Logger log = LoggerFactory.getLogger(BookService.class);

    private final BookRepository bookRepository;
    private final BookStatusService bookStatusService;

    public BookService(BookRepository bookRepository, BookStatusService bookStatusService ) {
        this.bookRepository = bookRepository;
        this.bookStatusService = bookStatusService;
    }
    /**
     * Return a {@link Page} of {@link User} which matches the criteria from the database
     *
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<Book> findByCriteria(BookFilter criteria, Pageable page) {
        log.debug("find by criteria : {}", criteria);
        final Specification<Book> specification = BookSpecification.of(criteria);
        return bookRepository.findAll(specification,page);
    }

    /**
     * Create {@link Book} by user
     *
     * @param book                            book object of the Book
     * @return Book
     */
    public Book createOrUpdate(Book book) {
        log.debug("Request to create or update Book");
        return bookRepository.save(book);
    }

    /**
     * Find {@link Book} by id
     *
     * @param id                            id ot the Book
     * @return Wholesale Document
     * @throws EntityDoesNotExistException  if the Book is not found with given id
     */
    public Book findOne(Long id) {
        log.debug("Request to get Book with id : {}", id);
        return bookRepository.findById(id).orElseThrow(() -> new EntityDoesNotExistException(ENTITY_NAME, id));
    }

    /**
     * Publish {@link Book} (Change the status to published)
     *
     * @param id of the Book
     */
    public Book changeBookStatusToPublished(Long id) {
        log.debug("Request to publish Book with id: {}", id);
        Book book = findOne(id);
        /*
        Prevalidation code if needed
        * */
        book.setBookStatus(bookStatusService.findOneByCode(BookStatuses.PUBLISHED_CODE));
        book.setPublishedAt(LocalDateTime.now());
        /*
        Post action after change status tu publish
        * */
        return book;
    }

    /**
     * Scheduled method for creating reports for new books and isbn data
     */
    @Scheduled(cron = "${cron.createReportNewIsbnBooks}")
    public void createReportNewIsbnBooks() {

        log.info("Cron job started: Creating reports for new books and isbn data {}", LocalDateTime.now());

        List<Book> bookList = bookRepository.findAllByBookStatusAndPublishedAtAfter(
                bookStatusService.findOneByCode(BookStatuses.PUBLISHED_CODE),LocalDateTime.now());

        List<AutomaticEmailProperties> emailProperties = new ArrayList<>();

        /*Add book list data to AutomaticEmailProperties List and send email*/
        sendEmailNotifications(emailProperties);
    }

    public void sendEmailNotifications(List<AutomaticEmailProperties> emailProperties) {
        log.debug("Sending email notifications");
        Predicate<AutomaticEmailProperties> addressIsNotEmpty = aep -> StringUtils.isNotEmpty(aep.getEmailAddress());
        Consumer<AutomaticEmailProperties> sendEmailAndLogAction = aep -> {
            log.debug("Sending notification to {}", aep.getEmailAddress());
            //emailService.sendNotificationEmailAboutReport(aep);
        };
        emailProperties.parallelStream().filter(addressIsNotEmpty).forEach(sendEmailAndLogAction);
    }
}
