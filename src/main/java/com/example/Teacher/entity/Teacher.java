package com.example.Teacher.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Teacher {
    @Id
//    @SequenceGenerator(
//            name = "teacher_sequence",
//            sequenceName = "teacher_sequence",
//            allocationSize = 1
//    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    @Column(name = "id")
    private Long id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String firstname;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String lastname;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "password",
            nullable = false
    )
    private String password;

    @OneToMany(
            mappedBy = "teacher",
            cascade = CascadeType.ALL

    )
    private List <Book> books = new ArrayList<>();

    public Teacher(String firstname, String lastname, String email, String password) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public void addBook(Book book){
        if (books == null){
            books = new ArrayList<>();
        }

        books.add(book);

        book.setTeacher(this);
    }
}
