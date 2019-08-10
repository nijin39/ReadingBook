package com.tandem6.readingbook.book.ui;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.tandem6.readingbook.book.application.BookApplication;
import com.tandem6.readingbook.book.domain.Book;
import com.tandem6.readingbook.book.infra.DTO.KakaoBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value="/api")
public class BookRestController {

    final private BookApplication bookApplication;

    public BookRestController(BookApplication bookApplication) {
        this.bookApplication = bookApplication;
    }

    @GetMapping("/hello")
    public String hello(){
        log.info("Enter Hello");
        return "{\"title\":\"hello\", \"body\":\"seoung joo\"}";
    }

    @PostMapping("/book/isbn/{isbn}")
    public List<KakaoBook> registrationBook(@PathVariable String isbn) throws IOException, UnirestException {
       return bookApplication.findByIsbnAndSave(isbn);
    }

    @GetMapping("/books")
    public List<Book> findAllMyBook() {
        return bookApplication.findAllMyBook();
    }

    @GetMapping("/book/isbn/{isbn}")
    public List<Book> findByIsbn(@PathVariable String isbn) {
        return bookApplication.findByIsbn(isbn);
    }
}
