package com.nextuple.learning.backend.repositories;

import com.nextuple.learning.backend.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction,Long> {
    List<Transaction> findTransactionByUsername(String username);
}
