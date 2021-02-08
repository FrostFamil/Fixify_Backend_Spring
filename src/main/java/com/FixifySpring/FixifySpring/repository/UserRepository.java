package com.FixifySpring.FixifySpring.repository;

import com.FixifySpring.FixifySpring.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {

}
