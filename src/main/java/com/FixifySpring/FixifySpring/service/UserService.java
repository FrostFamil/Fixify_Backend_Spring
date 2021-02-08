package com.FixifySpring.FixifySpring.service;

import com.FixifySpring.FixifySpring.models.User;
import com.FixifySpring.FixifySpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public String test(User user){
        repository.save(user);
        return "Added user";
    }
}
