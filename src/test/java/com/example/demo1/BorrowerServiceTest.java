package com.example.demo1;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.demo1.borrower.Borrower;
import com.example.demo1.borrower.BorrowerRepository;
import com.example.demo1.borrower.BorrowerService;
import com.example.demo1.borrower.BorrowerService.InvalidDataException;

class BorrowerServiceTest {

    @Mock
    private BorrowerRepository borrowerRepository;

    @InjectMocks
    private BorrowerService borrowerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);  // Initialize mocks
    }

    @Test
    void testGetBorrowers() {
        // Arrange
        Borrower borrower = new Borrower(1, "marcus", "marcus@gmail.com");

        // Act
        List<Borrower> borrowers = borrowerService.getBorrowers();

        // Assert
        assertNotNull(borrowers);
        assertEquals(1, borrowers.size());
        assertEquals(borrower.getName(), borrowers.get(0).getName());
    }

    @Test
    void testRegisterBorrower_Success() {
        // Arrange
        Borrower borrower = new Borrower(1, "Marcus", "marcus@gmail.com");
        when(borrowerRepository.save(any(Borrower.class))).thenReturn(borrower);

        // Act
        Borrower registeredBorrower = borrowerService.registerBorrower(borrower);

        // Assert
        assertNotNull(registeredBorrower);
        assertEquals("Marcus", registeredBorrower.getName());
        assertEquals("marcus@gmail.com", registeredBorrower.getEmailAddress());
    }

    @Test
    void testRegisterBorrower_InvalidName() {
        // Arrange
        Borrower borrower = new Borrower(1, "", "marcus@gmail.com");

        // Act & Assert
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> {
            borrowerService.registerBorrower(borrower);
        });
        assertEquals("Name must not be null or blank", exception.getMessage());
    }

    @Test
    void testRegisterBorrower_InvalidEmail() {
        // Arrange
        Borrower borrower = new Borrower(1, "Marcus", "invalid-email");

        // Act & Assert
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> {
            borrowerService.registerBorrower(borrower);
        });
        assertEquals("Invalid email address format", exception.getMessage());
    }

    @Test
    void testRegisterBorrower_InvalidEmailBlank() {
        // Arrange
        Borrower borrower = new Borrower(1, "Marcus", "");

        // Act & Assert
        InvalidDataException exception = assertThrows(InvalidDataException.class, () -> {
            borrowerService.registerBorrower(borrower);
        });
        assertEquals("Email address must not be null or blank", exception.getMessage());
    }
}