package com.example.demo1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo1.book.BookService.InvalidDataException;
import com.example.demo1.borrower.BorrowerService;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler(MethodArgumentNotValidException.class)
    // public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
    //     String message = ex.getBindingResult().getFieldErrors().stream()
    //         .map(error -> error.getField() + " " + error.getDefaultMessage())
    //         .findFirst()
    //         .orElse("Invalid data or missing value");

    //     // Rethrow as InvalidDataException with a meaningful message
    //     throw new BorrowerService.InvalidDataException(message);
    // }

    @ExceptionHandler(BorrowerService.InvalidDataException.class)
    public ResponseEntity<String> handleInvalidDataException(BorrowerService.InvalidDataException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<String> handleInvalidDataException(InvalidDataException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        ex.printStackTrace(); // For debugging purposes
        return ResponseEntity.status(500).body("An unexpected error occurred.");
    }
}
