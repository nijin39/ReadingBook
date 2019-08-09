package com.tandem6.readingbook.book;


import com.mashape.unirest.http.exceptions.UnirestException;
import com.tandem6.readingbook.book.domain.BookExternalRepository;
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

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DaumBookRepositoryTest {

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

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme