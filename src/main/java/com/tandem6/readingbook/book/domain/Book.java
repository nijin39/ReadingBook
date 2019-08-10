package com.tandem6.readingbook.book.domain;

import com.tandem6.readingbook.book.infra.DTO.KakaoBook;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@EqualsAndHashCode
@Data
@Entity
public class Book {
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
        this.isbn = kakaoBook.getIsbn();
    }
}
