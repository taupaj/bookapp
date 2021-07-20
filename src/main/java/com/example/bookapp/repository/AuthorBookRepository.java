package com.example.bookapp.repository;

import com.example.bookapp.domain.AuthorBook;
import com.example.bookapp.filter.AuthorBookFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AuthorBookRepository extends JpaRepository<AuthorBook, Long>, JpaSpecificationExecutor<AuthorBook> {

    @Query(value = "select " +
                    "   coalesce(a.first_name, '') || ' ' || coalesce(a.last_name, '') as author  " +
                    "   a.createdAt as authorCreationDate  " +
                    "   count(distinct ab.book_id) as bookNumber  " +
                    "from " +
                    "   author_book ab " +
                    "join " +
                    "   app_user a on ab.user_id = a.id and is_author = :#{#filter.isAuthor} " +
                    "join " +
                    "   book b on ab.book_id = b.id and b.status = :#{#filter.bookStatusEnum} " +
                    "where " +
                    "   (:#{#filter.authorFirstName} is null or a.first_name like '%:#{#filter.authorFirstName}%') " +
                    "   (:#{#filter.authorLastName} is null or a.last_name like '%:#{#filter.authorLastName}%') " +
                    "group by " +
                    "   coalesce(a.first_name, '') || ' ' || coalesce(a.last_name, ''), " +
                    "   a.createdAt "
            , nativeQuery = true)
    Page<AuthorBook> getAllAuthorsWithPublishedBooks(@Param("filter") AuthorBookFilter filter, Pageable pageable);
}
