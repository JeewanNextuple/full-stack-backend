package com.nextuple.learning.backend.services;

import com.nextuple.learning.backend.models.Transaction;

import java.util.List;

public interface TransactionService {
    String saveNewTransaction(Transaction transaction) throws Exception;
    List<Transaction> getTransactionByEmail(String email);
    Object getAllCashBacksForUser(String username);
}
