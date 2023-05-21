package com.example.demo.controllers;

import com.example.demo.dto.BookDTO;
import com.example.demo.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    public BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveBook(@RequestBody BookDTO bookDTO) {
        bookService.saveBook(bookDTO);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
