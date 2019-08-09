package com.tandem6.readingbook.book.infra;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.tandem6.readingbook.book.domain.BookExternalRepository;
import com.tandem6.readingbook.book.infra.DTO.KakaoBook;
import com.tandem6.readingbook.book.infra.DTO.KakaoBookWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Component("daum")
public class DaumBookRepository implements BookExternalRepository {

    @Value("${kakao.api.key}")
    private String apiKey;
    @Value("${kakao.api.host}")
    private String host;
    @Value("${kakao.book.api.uri}")
    private String uri;


    @Override
    public List<KakaoBook> findByName(String name) throws UnirestException, IOException {
        KakaoBookWrapper kakaoBooks = getKakaoBookWrapper(name, "title");
        return kakaoBooks.getDocuments();
    }

    @Override
    public List<KakaoBook> findByIsbn(String isbn) throws UnirestException, IOException {
        KakaoBookWrapper kakaoBooks = getKakaoBookWrapper(isbn, "isbn");
        return kakaoBooks.getDocuments();
    }

    private KakaoBookWrapper getKakaoBookWrapper(String value, String key) throws UnirestException, IOException {
        HttpResponse<String> response = Unirest.get(host + uri)
                .queryString("target", key)
                .queryString("query", URLEncoder.encode(value, "UTF-8").replaceAll("\\+", "%20"))
                .queryString("sort", "latest")
                .header("Authorization", apiKey)
                .asString();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(response.getBody(), KakaoBookWrapper.class);
    }
}
