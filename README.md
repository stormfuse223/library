**Library Management System API**
A Spring Boot-based RESTful API for managing library operations, including borrower registration, book cataloging, and borrowing/returning books. This project demonstrates the use of Spring Data JPA, MySQL, and other modern backend technologies to build a robust and scalable library management system.

**Features**
Borrower Management: Register and manage library borrowers with validations for email and name.
Book Management: Add, view, and manage books with details like ISBN, title, and author.
Book Borrowing/Returning: Seamlessly borrow and return books while tracking their availability status.
RESTful API Design: Clean and intuitive endpoints for interacting with the library system.
Database Integration: Uses MySQL for persistent data storage with Spring Data JPA for simplified ORM.
Validation: Ensures data integrity with field-level validations using Jakarta Bean Validation.

**Technologies Used**
Java 17: Modern Java features for cleaner and efficient code.
Spring Boot 3.x: Framework for rapid application development.
Spring Data JPA: Simplified data access with robust repository patterns.
MySQL: Reliable relational database for storing borrower and book information.
Postman: Testing and interacting with the API.

**Setup Instructions**
Clone the repository.
Configure your MySQL database in application.properties.
Run the application using mvn spring-boot:run.
Use Postman or other tools to test the API endpoints.

**Endpoints Overview**
POST /api/library/borrowers: Register a new borrower.
POST /api/library/books: Add a new book to the catalog.
GET /api/library/books: Retrieve all books in the library.
POST /api/library/borrow/{borrowerId}/{bookId}: Borrow a book.
POST /api/library/return/{bookId}: Return a borrowed book.
