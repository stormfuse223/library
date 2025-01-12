package com.example.demo1.book;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByIsbnNo(int isbnNo);
}
