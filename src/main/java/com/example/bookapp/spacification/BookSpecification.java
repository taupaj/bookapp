package com.example.bookapp.spacification;

import com.example.bookapp.domain.Book;
import com.example.bookapp.filter.BookFilter;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpecification implements Specification<Book> {

    private static final long serialVersionUID = -3611113127063319681L;

    private BookFilter filter;

    public BookSpecification(BookFilter filter) {
        this.filter = filter;
    }

    public static BookSpecification of(BookFilter bookFilter) {
        return new BookSpecification(bookFilter);
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        String likeFormat = "%%%s%%";
        List<Predicate> predicates = new ArrayList<>();

        /*if (filter.getId() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Book_.id), filter.getId()));
        }

        if (filter.getTitle() != null) {
            predicates.add(criteriaBuilder.like(root.get(Book_.title),
                    String.format(likeFormat, filter.getTitle())));
        }

        if (filter.getGenre() != null) {
            predicates.add(criteriaBuilder.like(root.get(Book_.genre),
                    String.format(likeFormat, filter.getGenre())));
        }

        if (filter.getIsbn() != null) {
            predicates.add(criteriaBuilder.like(root.get(Book_.isbn),
                    String.format(likeFormat, filter.getIsbn())));
        }*/

        Predicate[] predicateArray = predicates.toArray(new Predicate[0]);

        return criteriaBuilder.and(predicateArray);
    }
}
