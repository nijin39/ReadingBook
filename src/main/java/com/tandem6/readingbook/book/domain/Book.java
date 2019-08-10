package com.tandem6.readingbook.book.domain;

import com.tandem6.readingbook.book.infra.DTO.KakaoBook;
import com.tandem6.readingbook.common.domain.TimeEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
public class Book extends TimeEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column private String title;
    @Column private String contents;
    @Column private String url;

    @Column(unique=true)
    private String isbn;
    @Column private String datetime;

    @ElementCollection
    @CollectionTable(name = "book_authors", joinColumns = @JoinColumn(name = "book_id"))
    @Column
    private List<String> authors;

    @Column private String publisher;

    @ElementCollection
    @CollectionTable(name = "book_translators", joinColumns = @JoinColumn(name = "book_id"))
    @Column
    private List<String> translators;

    @Column private Integer price;
    @Column private Integer sale_price;
    @Column private String thumbnail;
    @Column private String status;

    public Book(KakaoBook kakaoBook) {
        this.title = kakaoBook.getTitle();
        this.contents = kakaoBook.getContents();
        this.url = kakaoBook.getUrl();
        this.isbn = kakaoBook.getIsbn();
        this.datetime = kakaoBook.getDatetime();
        this.authors = kakaoBook.getAuthors();
        this.publisher = kakaoBook.getPublisher();
        this.translators = kakaoBook.getTranslators();
        this.price = kakaoBook.getPrice();
        this.sale_price = kakaoBook.getSale_price();
        this.thumbnail = kakaoBook.getThumbnail();
        this.status = kakaoBook.getStatus();
    }
}
