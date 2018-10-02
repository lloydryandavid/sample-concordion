package org.lloydryandavid.bookapp.controller;


import org.lloydryandavid.bookapp.model.Book;
import org.lloydryandavid.bookapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;


@RestController
@RequestMapping("/api")
public class BookController {


    @Autowired
    BookRepository bookRepository;

    @RequestMapping(
            value = "/books",
            params = { "title", "author" },
            method = GET)
    public List<Book> getAllBooks(@RequestParam("author") String author, @RequestParam("title") String title) {
        return bookRepository.fetchBooks(author, title);
    }

    @PostMapping("/books")
    public ResponseEntity createBookRecord(@Valid @RequestBody Book book) {
        String author = book.getAuthor();
        String title = book.getTitle();
        int recordCount = bookRepository.fetchBooks(author, title).size();
        if(recordCount!=0){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("{\"reason\":\"Entry already exists\"}");
        }
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"Successfully added entry\"}");
    }

}
