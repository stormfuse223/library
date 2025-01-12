package com.example.demo1.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/book")
public class BookController {
    private final BookService bookService;
    
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.registerBook(book));
    }

    @PostMapping("/borrow/{bookId}") 
    public ResponseEntity<String> borrowBook(@PathVariable int bookId) {
        return ResponseEntity.ok(bookService.borrowBook(bookId)); 
    }

    @PostMapping("/return/{bookId}")
    public ResponseEntity<String> returnBook(@PathVariable int bookId) {
        return ResponseEntity.ok(bookService.returnBook(bookId));
    }

    @GetMapping("/getBooks")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}
