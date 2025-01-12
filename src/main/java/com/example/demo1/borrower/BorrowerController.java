package com.example.demo1.borrower;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/borrower")
public class BorrowerController {
    private final BorrowerService borrowerService; 
    
    @Autowired //auto inject the dependency for this constructor
    public BorrowerController(BorrowerService borrowerService) {
        this.borrowerService = borrowerService;
    }

    // @GetMapping
	// public List<Borrower> getBorrowers() {
	// 	return borrowerService.getBorrowers();
	// }

    @PostMapping("/register")
    public ResponseEntity registerBorrower(@RequestBody Borrower borrower) {
        return ResponseEntity.ok(borrowerService.registerBorrower(borrower));
    }
    
}
