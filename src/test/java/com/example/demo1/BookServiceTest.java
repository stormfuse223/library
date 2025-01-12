package com.example.demo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo1.book.Book;
import com.example.demo1.book.BookRepository;
import com.example.demo1.book.BookService;
import com.example.demo1.book.BookService.InvalidDataException;

public class BookServiceTest {

    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);
    }

    @Test
    void testRegisterBook_ValidBook() {
        Book book = new Book(123, "Harry Potter", "J.K. Rowling");
        when(bookRepository.save(book)).thenReturn(book);

        String result = bookService.registerBook(book);

        assertEquals("Book Registered", result);
    }

    @Test
    void testRegisterBook_BookWithSameIsbn() {
        Book existingBook = new Book(123, "Harry Potter", "J.K. Rowling");
    
        Book bookToRegister = new Book(123, "New Title", "New Author");
    
        when(bookRepository.findByIsbnNo(123)).thenReturn(List.of(existingBook));
    
        String result = bookService.registerBook(bookToRegister);
    
        assertEquals("Book with the same ISBN should have the same title and author.", result);
    }

    @Test
    void testRegisterBook_InvalidBook() {
        Book book = new Book(123, null, "J.K. Rowling");

        assertThrows(InvalidDataException.class, () -> bookService.registerBook(book));
    }
}
