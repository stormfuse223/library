package com.example.demo1.borrower;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class BorrowerService {
    private final BorrowerRepository borrowerRepository; 
    
    public BorrowerService(BorrowerRepository borrowerRepository) {
        this.borrowerRepository = borrowerRepository;
    }

    public List<Borrower> getBorrowers() {
		return List.of(
			new Borrower(1, "marcus", "marcus@gmail.com")
		);
	}

    public Borrower registerBorrower(@Valid Borrower borrower) {
        if (borrower.getName() == null || borrower.getName().isBlank()) {
            throw new InvalidDataException("Name must not be null or blank");
        }
        if (borrower.getEmailAddress() == null || borrower.getEmailAddress().isBlank()) {
            throw new InvalidDataException("Email address must not be null or blank");
        }
        // You can also add custom email format validation if needed
        if (!borrower.getEmailAddress().matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$")) {
            throw new InvalidDataException("Invalid email address format");
        }
        return borrowerRepository.save(borrower);
    }

    public class InvalidDataException extends RuntimeException {
        public InvalidDataException(String message) {
            super(message);
        }
    }
}
