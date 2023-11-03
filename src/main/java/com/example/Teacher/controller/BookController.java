package com.example.Teacher.controller;

import com.example.Teacher.dto.request.BookRequestDto;
import com.example.Teacher.entity.Book;
import com.example.Teacher.implementation.BookServiceImplementation;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    private final BookServiceImplementation bookServiceImplementation;

    @Autowired
    public BookController(BookServiceImplementation bookServiceImplementation) {
        this.bookServiceImplementation = bookServiceImplementation;
    }

    @GetMapping("/addBook")
    public String getBookStorePage(Model model) {
        model.addAttribute("addBookRequest", new BookRequestDto());
        return "addToBookStorePage";
    }

    @PostMapping("/addBook")
    public String addBookToBookStore(@ModelAttribute BookRequestDto bookRequestDto, HttpSession session) {
        System.out.println(bookRequestDto);
        Long id = (Long) session.getAttribute("teacherId");
        Book addedBook = bookServiceImplementation.addBook(bookRequestDto, id);
        return addedBook == null ? "errorPage" : "successfulBookCreation";
    }
}
