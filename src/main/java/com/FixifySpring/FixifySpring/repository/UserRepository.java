package com.FixifySpring.FixifySpring.repository;

import com.FixifySpring.FixifySpring.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
