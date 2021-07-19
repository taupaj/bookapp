package com.example.bookapp.spacification;

import com.example.bookapp.domain.AuthorBook;
import com.example.bookapp.domain.Book;
import com.example.bookapp.domain.User;
import com.example.bookapp.filter.AuthorBookFilter;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AuthorBookSpecification implements Specification<AuthorBook> {

    private static final long serialVersionUID = -1111113127063319681L;

    private final AuthorBookFilter filter;

    public AuthorBookSpecification(AuthorBookFilter filter) {
        this.filter = filter;
    }

    public static AuthorBookSpecification of(AuthorBookFilter authorBookFilter) {
        return new AuthorBookSpecification(authorBookFilter);
    }

    @Override
    public Predicate toPredicate(Root<AuthorBook> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        String likeFormat = "%%%s%%";
        List<Predicate> predicates = new ArrayList<>();

       /* Join<AuthorBook, User> authorBookUserJoin = root.join(AuthorBook_.authorId, JoinType.INNER);
        Join<AuthorBook, Book> authorBookBookJoin = root.join(AuthorBook_.bookId, JoinType.INNER);

        if (CollectionUtils.isNotEmpty(filter.getIds())) {
            predicates.add(root.get(AuthorBook_.id).in(filter.getIds()));
        }

        if (filter.getId() != null) {
            predicates.add(criteriaBuilder.equal(root.get(AuthorBook_.id), filter.getId()));
        }

        if (filter.getAuthorId() != null) {
            predicates.add(criteriaBuilder.equal(
                    authorBookUserJoin.get(User_.id), filter.getAuthorId()));
        }

        if (filter.getBookId() != null) {
            predicates.add(criteriaBuilder.equal(
                    authorBookBookJoin.get(Book_.id), filter.getBookId()));
        }

        if (filter.getBookGenre() != null) {
            predicates.add(criteriaBuilder.like(
                    authorBookBookJoin.get(Book_.genre), filter.getBookGenre()));
        }

        if (filter.getBookIsbn() != null) {
            predicates.add(criteriaBuilder.like(
                    authorBookBookJoin.get(Book_.isbn), filter.getBookIsbn()));
        }

        if (filter.getBookTitle() != null) {
            predicates.add(criteriaBuilder.like(
                    authorBookBookJoin.get(Book_.title), filter.getBookTitle()));
        }

        if (filter.getBookStatusEnum() != null) {
            predicates.add(criteriaBuilder.equal(
                    authorBookBookJoin.get(Book_.bookStatusEnum), filter.getBookStatusEnum()));
        }

        if (filter.getBookPublishedFrom() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                    authorBookBookJoin.get(Book_.publishedAt), filter.getBookPublishedFrom()));
        }

        if (filter.getBookPublishedTo() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(
                    authorBookBookJoin.get(Book_.publishedAt), filter.getBookPublishedTo()));
        }

        if (filter.getAuthorFirstName() != null) {
            predicates.add(criteriaBuilder.like(
                    authorBookUserJoin.get(User_.firstname), filter.getAuthorFirstName()));
        }

        if (filter.getAuthorLastName() != null) {
            predicates.add(criteriaBuilder.like(
                    authorBookUserJoin.get(User_.lastname), filter.getAuthorLastName()));
        }

        if (filter.getAuthorCreatedFrom() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(
                    authorBookUserJoin.get(User_.createdAt), filter.getAuthorCreatedFrom()));
        }

        if (filter.getAuthorCreatedTo() != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(
                    authorBookUserJoin.get(User_.createdAt), filter.getAuthorCreatedTo()));
        }

        // order by
        List<Order> orderList = getOrderBy(authorBookUserJoin, authorBookBookJoin, criteriaBuilder);

        if (CollectionUtils.isNotEmpty(orderList)) {
            criteriaQuery.orderBy(orderList);
        }*/

        Predicate[] predicateArray = predicates.toArray(new Predicate[0]);

        return criteriaBuilder.and(predicateArray);
    }

    /*private List<Order> getOrderBy(
            Join<AuthorBook, User> authorBookUserJoin,
            Join<AuthorBook, Book> authorBookBookJoin,
            CriteriaBuilder criteriaBuilder)
    {
        List<Order> orderList = new ArrayList<>();

        Expression<LocalDateTime> publishedAt = authorBookBookJoin.get(Book_.publeshedAt);
        Expression<LocalDateTime> createdAt = authorBookUserJoin.get(User_.createdAt);

        Order byPublishedAt = criteriaBuilder.desc(publishedAt);
        Order byCreatedAt = criteriaBuilder.desc(createdAt);

        orderList.add(byPublishedAt);
        orderList.add(byCreatedAt);
        return orderList;
    }*/
}
