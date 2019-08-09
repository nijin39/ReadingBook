package com.tandem6.readingbook.book.domain;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.tandem6.readingbook.book.infra.DTO.KakaoBook;

import java.io.IOException;
import java.util.List;

public interface BookExternalRepository {
    List<KakaoBook> findByName(String name) throws UnirestException, IOException;
    List<KakaoBook> findByIsbn(String name) throws UnirestException, IOException;
}
