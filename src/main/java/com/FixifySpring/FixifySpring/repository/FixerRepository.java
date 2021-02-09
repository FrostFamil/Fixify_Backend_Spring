package com.FixifySpring.FixifySpring.repository;

import com.FixifySpring.FixifySpring.models.Fixer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FixerRepository extends MongoRepository<Fixer, Long> {
    Optional<Fixer> findFixerByEmail(String email);
}
