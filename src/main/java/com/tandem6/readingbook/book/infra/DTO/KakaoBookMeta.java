package com.tandem6.readingbook.book.infra.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KakaoBookMeta {
    private Boolean is_end;
    private Integer pageable_count;
    private Integer total_count;
}
