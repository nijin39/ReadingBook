package com.tandem6.readingbook.book.infra.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KakaoBookWrapper {

    private KakaoBookMeta meta;
    private List<KakaoBook> documents;
}
