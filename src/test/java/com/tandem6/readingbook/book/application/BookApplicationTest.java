package com.tandem6.readingbook.book.application;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.tandem6.readingbook.book.domain.Book;
import com.tandem6.readingbook.book.domain.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookApplicationTest {

    @Autowired
    private BookApplication bookApplication;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFindByisbnAndSave() throws IOException, UnirestException {
        bookApplication.findByisbnAndSave("1155026519");
        final List<Book> allBook = bookRepository.findAll();
        Assert.assertEquals(1, allBook.size());
    }
}