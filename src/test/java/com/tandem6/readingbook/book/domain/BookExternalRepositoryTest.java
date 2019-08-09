package com.tandem6.readingbook.book.domain;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.tandem6.readingbook.book.infra.DTO.KakaoBook;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookExternalRepositoryTest {

    @Autowired
    @Qualifier(value = "daum")
    BookExternalRepository daumBookRepository;

    @Test
    public void testFindByName() throws IOException, UnirestException {
        List<KakaoBook> result = daumBookRepository.findByName("박지성");
        log.info("RESULT ::::::{}", result.toString());
        Assert.assertNotNull(result);
    }

    @Test
    public void testFindByIsbn() throws IOException, UnirestException {
        List<KakaoBook> result = daumBookRepository.findByIsbn("1155026519");
        log.info("RESULT ::::::{}", result.toString());
        Assert.assertNotNull(result);
    }
}