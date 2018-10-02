package org.lloydryandavid.bookapp.repository;


import org.lloydryandavid.bookapp.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b.author, b.title FROM Book b WHERE b.author=:author AND b.title=:title")
    public List<Book> fetchBooks(@Param("author") String author, @Param("title") String title);

}