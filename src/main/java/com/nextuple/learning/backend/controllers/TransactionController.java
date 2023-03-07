package com.nextuple.learning.backend.controllers;

import com.nextuple.learning.backend.models.Transaction;
import com.nextuple.learning.backend.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/transaction")
    public ResponseEntity<String> addNewTransaction(@RequestBody Transaction transaction) throws Exception {
        return new ResponseEntity<String>(transactionService.saveNewTransaction(transaction),HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/transactions/{username}")
    public ResponseEntity<?> getTransactionsOfUser(@PathVariable String username){
        return new ResponseEntity<>(transactionService.getTransactionByEmail(username),HttpStatus.OK);
    }
    @CrossOrigin
    @GetMapping("/cashbacks/{username}")
    public ResponseEntity<?> getAllCashBacks(@PathVariable String username){
        return new ResponseEntity<>(transactionService.getAllCashBacksForUser(username),HttpStatus.OK);
    }

}
