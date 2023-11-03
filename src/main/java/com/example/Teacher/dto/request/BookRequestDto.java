package com.example.Teacher.dto.request;

import lombok.*;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestDto {
    private String bookName;
    private String author;
    private Integer price;
}
