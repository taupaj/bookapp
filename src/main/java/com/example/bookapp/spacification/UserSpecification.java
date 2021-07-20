package com.example.bookapp.spacification;

import com.example.bookapp.domain.User;
import com.example.bookapp.domain.User_;
import com.example.bookapp.filter.UserFilter;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class UserSpecification implements Specification<User> {

    private static final long serialVersionUID = -1554813127063319681L;

    private UserFilter filter;

    public UserSpecification(UserFilter filter) {
        this.filter = filter;
    }

    public static UserSpecification of(UserFilter userFilter) {
        return new UserSpecification(userFilter);
    }

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        String likeFormat = "%%%s%%";
        List<Predicate> predicates = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(filter.getIds())) {
            predicates.add(root.get(User_.id).in(filter.getIds()));
        }

        if (filter.getId() != null) {
            predicates.add(criteriaBuilder.equal(root.get(User_.id), filter.getId()));
        }

        if (filter.getLastName() != null) {
            predicates.add(criteriaBuilder.like(root.get(User_.lastName),
                    String.format(likeFormat, filter.getLastName())));
        }

        if (filter.getFirstName() != null) {
            predicates.add(criteriaBuilder.like(root.get(User_.firstName),
                    String.format(likeFormat, filter.getFirstName())));
        }

        if (filter.getUsername() != null) {
            predicates.add(criteriaBuilder.like(root.get(User_.username),
                    String.format(likeFormat, filter.getUsername())));
        }

        if (BooleanUtils.isTrue(filter.getIsAuthor())) {
            predicates.add(criteriaBuilder.isTrue(root.get(User_.isAuthor)));
        }

        if (BooleanUtils.isFalse(filter.getIsAuthor())) {
            predicates.add(criteriaBuilder.or(criteriaBuilder.isFalse(root.get(User_.isAuthor)),
                                              criteriaBuilder.isNull(root.get(User_.isAuthor))));
        }

        Predicate[] predicateArray = predicates.toArray(new Predicate[0]);

        return criteriaBuilder.and(predicateArray);
    }
}
