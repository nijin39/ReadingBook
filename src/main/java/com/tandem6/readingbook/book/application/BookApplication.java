package com.tandem6.readingbook.book.application;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.tandem6.readingbook.book.domain.Book;
import com.tandem6.readingbook.book.domain.BookExternalRepository;
import com.tandem6.readingbook.book.domain.BookRepository;
import com.tandem6.readingbook.book.infra.DTO.KakaoBook;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BookApplication {

    final private BookRepository bookRepository;
    final private BookExternalRepository bookExternalRepository;

    public BookApplication(BookRepository bookRepository, BookExternalRepository bookExternalRepository) {
        this.bookRepository = bookRepository;
        this.bookExternalRepository = bookExternalRepository;
    }

    public void findByisbnAndSave(String isbn) throws IOException, UnirestException {
        List<KakaoBook> books = bookExternalRepository.findByIsbn(isbn);
        books.stream()
                .forEach(book -> bookRepository.save(new Book(book)));
    }
}
