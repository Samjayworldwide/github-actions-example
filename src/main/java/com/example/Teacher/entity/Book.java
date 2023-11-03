package com.example.Teacher.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Book {
    @Id
    @SequenceGenerator(
            name = "book_sequence",
            sequenceName = "book_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "book_sequence")
    private Long id;
    private String bookName;
    private String author;
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE,
                                                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(
            name = "teacher_id",
            nullable = false,
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "teacher_lesson_book_fk"
            )
    )
    private Teacher teacher;

    public Book(String bookName, String author, Integer price) {
        this.bookName = bookName;
        this.author = author;
        this.price = price;
    }
}
