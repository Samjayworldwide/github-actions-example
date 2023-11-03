package com.example.Teacher.service;

import com.example.Teacher.dto.request.BookRequestDto;
import com.example.Teacher.entity.Book;

public interface BookService {
    Book addBook(BookRequestDto bookRequestDto,Long id);
}
