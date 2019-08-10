package com.tandem6.readingbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ReadingbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingbookApplication.class, args);
    }

}
