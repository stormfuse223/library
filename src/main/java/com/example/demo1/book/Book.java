package com.example.demo1.book;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id; 

    @NotNull
    private Integer isbnNo;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotNull
    private Boolean isBorrowed = false; 

    public Book() {

    }

    public Book(Integer isbnNo, String title, String author) {
        this.isbnNo = isbnNo;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getIsbnNo() {
        return isbnNo;
    }
    public void setIsbnNo(Integer isbnNo) {
        this.isbnNo = isbnNo;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public Boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(Boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    
    
}
