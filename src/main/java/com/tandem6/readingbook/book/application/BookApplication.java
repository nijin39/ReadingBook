package com.tandem6.readingbook.book.application;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.tandem6.readingbook.book.domain.Book;
import com.tandem6.readingbook.book.domain.BookExternalRepository;
import com.tandem6.readingbook.book.domain.BookRepository;
import com.tandem6.readingbook.book.infra.DTO.KakaoBook;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public List<Book> findAllMyBook() {
        return bookRepository.findAll();
    }

    @Transactional
    public List<Book> findByIsbn(String isbn) {
        return bookRepository.findByIsbnContainingIgnoreCase(isbn);
    }

    @Transactional
    public List<KakaoBook> findByIsbnAndSave(String isbn) throws IOException, UnirestException {
        List<KakaoBook> books = bookExternalRepository.findByIsbn(isbn);

        if( alreadyRegistrated(isbn) ){
            throw new RuntimeException("Already Registrated the book");
        }

        if(hasBook(books)){
            books.stream()
                    .forEach(book -> bookRepository.save(new Book(book)));
        } else {
            throw new RuntimeException("No Book");
        }
        return books;
    }

    private boolean alreadyRegistrated(String isbn) {
        List<Book> books = bookRepository.findByIsbnContainingIgnoreCase(isbn);
        return books.size() !=0 ? true : false;
    }

    private boolean hasBook(List<KakaoBook> books) {
        return books.size() != 0;
    }
}
