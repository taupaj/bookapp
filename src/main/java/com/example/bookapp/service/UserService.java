package com.example.bookapp.service;

import com.example.bookapp.domain.User;
import com.example.bookapp.filter.UserFilter;
import com.example.bookapp.repository.UserRepository;
import com.example.bookapp.spacification.UserSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    private static final String ENTITY_NAME = "User";

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create {@link User} by user
     *
     * @param user                            user object of the User
     * @return User
     */
    public User createOrUpdate(User user) {
        log.debug("Request to create or update User");
        return userRepository.save(user);
    }

    /**
     * Return a {@link Page} of {@link User} which matches the criteria from the database
     *
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<User> findByCriteria(UserFilter criteria, Pageable page) {
        prepareCriteria(criteria);
        log.debug("find by criteria : {}", criteria);
        final Specification<User> specification = UserSpecification.of(criteria);
        return userRepository.findAll(specification,page);
    }

    private void prepareCriteria(UserFilter userFilter) {
        userFilter.setAuthor(Boolean.TRUE);
    }

}
