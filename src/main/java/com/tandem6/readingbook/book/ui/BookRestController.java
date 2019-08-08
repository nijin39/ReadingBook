package com.tandem6.readingbook.book.ui;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value="/api")
public class BookRestController {

    @GetMapping("/hello")
    public String hello(){
        log.info("Enter Hello");
        return "{\"title\":\"hello\", \"body\":\"seoung joo\"}";
    }
}
