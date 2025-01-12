package com.example.demo1.book;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class BookService {
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public String registerBook(@Valid Book book) {
        try {
            validateRegister(book);
    
            List<Book> bookResult = bookRepository.findByIsbnNo(book.getIsbnNo());
            if (!bookResult.isEmpty()) {
                Book existingBook = bookResult.get(0);
                if (existingBook.getTitle().equals(book.getTitle()) &&
                    existingBook.getAuthor().equals(book.getAuthor())) {
                    bookRepository.save(book);
                    return "Book Registered";
                } else {
                    System.out.println(existingBook.getTitle() + "" + existingBook.getAuthor());
                    return "Book with the same ISBN should have the same title and author.";
                }
            }
    
            bookRepository.save(book);
            return "Book Registered";
        } catch (InvalidDataException e) {
            throw e; // Caught by GlobalExceptionHandler
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Unexpected error occurred: " + e.getMessage());
        }
    }

    public String borrowBook(int bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (!book.isBorrowed()) {
                book.setBorrowed(true);
                bookRepository.save(book);
                return "Book borrowed successfully.";
            } else {
                return "Book is already borrowed.";
            }
        }
        return "Book not found.";
    }

    public String returnBook(int bookId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isPresent()) {
            Book book = bookOptional.get();
            if (book.isBorrowed()) {
                book.setBorrowed(false);
                bookRepository.save(book);
                return "Book returned successfully.";
            } else {
                return "Book was not borrowed.";
            }
        }
        return "Book not found.";
    }

    public boolean validateRegister(Book book) {
        if (book.getTitle() == null || book.getTitle().isBlank()) {
            throw new InvalidDataException("Book Title must not be null or blank");
        }
        if (book.getAuthor() == null || book.getAuthor().isBlank()) {
            throw new InvalidDataException("Book Author must not be null or blank");
        }
        if (book.getIsbnNo() <= 0) {
            throw new InvalidDataException("Book Isbn Number must not be null or blank");
        }
        return true;
    }

    public class InvalidDataException extends RuntimeException {
        public InvalidDataException(String message) {
            super(message);
        }
    }

}
