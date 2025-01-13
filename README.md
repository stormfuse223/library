**Library Management System API** <br>
A Spring Boot-based RESTful API for managing library operations, including borrower registration, book cataloging, and borrowing/returning books. This project demonstrates the use of Spring Data JPA, MySQL, and other modern backend technologies to build a robust and scalable library management system.

**Features** <br>
Borrower Management: Register and manage library borrowers with validations for email and name. <br>
Book Management: Add, view, and manage books with details like ISBN, title, and author. <br>
Book Borrowing/Returning: Seamlessly borrow and return books while tracking their availability status. <br>
RESTful API Design: Clean and intuitive endpoints for interacting with the library system. <br>
Database Integration: Uses MySQL for persistent data storage with Spring Data JPA for simplified ORM. <br>
Validation: Ensures data integrity with field-level validations using Jakarta Bean Validation. <br>

**Technologies Used** <br>
Java 17: Modern Java features for cleaner and efficient code. <br>
Spring Boot 3.x: Framework for rapid application development. <br>
Spring Data JPA: Simplified data access with robust repository patterns. <br>
MySQL: Reliable relational database for storing borrower and book information. <br>
Postman: Testing and interacting with the API. <br>

**Setup Instructions** <br>
Clone the repository. <br>
Configure your MySQL database in application.properties. <br>
Run the application using mvn spring-boot:run. <br>
Use Postman or other tools to test the API endpoints. <br>

**Endpoints Overview**
POST /api/library/borrowers: Register a new borrower. <br>
POST /api/library/books: Add a new book to the catalog. <br>
GET /api/library/books: Retrieve all books in the library. <br>
POST /api/library/borrow/{borrowerId}/{bookId}: Borrow a book. <br>
POST /api/library/return/{bookId}: Return a borrowed book. <br>
