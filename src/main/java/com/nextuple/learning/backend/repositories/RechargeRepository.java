package com.nextuple.learning.backend.repositories;

import com.nextuple.learning.backend.models.Recharge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RechargeRepository extends MongoRepository<Recharge, String> {
    Recharge findByUsername(String username);
}
