package com.nextuple.learning.backend.repositories;

import com.nextuple.learning.backend.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    Boolean existsByEmail(String email);
    Boolean existsByPassword(String password);
}
