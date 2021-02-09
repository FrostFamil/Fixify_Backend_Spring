package com.FixifySpring.FixifySpring.service;

import com.FixifySpring.FixifySpring.RequestResponseFiles.LoginRequest;
import com.FixifySpring.FixifySpring.models.Fixer;
import com.FixifySpring.FixifySpring.models.User;
import com.FixifySpring.FixifySpring.repository.FixerRepository;
import com.FixifySpring.FixifySpring.repository.UserRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.BeanProperty;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private FixerRepository fixerRepository;

    public String test(){
        return "Added user";
    }

    public ResponseEntity<?> userSignup(User user){
        //user check
        Optional<User> existUser = repository.findUserByEmail(user.getEmail());
        if (!existUser.isEmpty()) {
            return new ResponseEntity<>("User exist with this email", HttpStatus.BAD_REQUEST);
        }
        repository.save(user);
        return new ResponseEntity<>("User added", HttpStatus.CREATED);
    }

    public ResponseEntity<?> fixerSignup(Fixer fixer){
        //user check
        Optional<Fixer> existFixer = fixerRepository.findFixerByEmail(fixer.getEmail());
        if (!existFixer.isEmpty()) {
            return new ResponseEntity<>("Fixer exist with this email", HttpStatus.BAD_REQUEST);
        }

        fixerRepository.save(fixer);
        return new ResponseEntity<>("Fixer added", HttpStatus.CREATED);
    }

    public ResponseEntity<?> userLogin(LoginRequest loginRequest) {
        //user check
        Optional<User> existUser = repository.findUserByEmail(loginRequest.getEmail());
        if (existUser.isEmpty()) {
            return new ResponseEntity<>("User does not exist with this email", HttpStatus.BAD_REQUEST);
        }


        return ResponseEntity.ok(existUser);
    }

    public ResponseEntity<?> fixerLogin(LoginRequest loginRequest) {
        //user check
        Optional<Fixer> existFixer = fixerRepository.findFixerByEmail(loginRequest.getEmail());
        if (existFixer.isEmpty()) {
            return new ResponseEntity<>("Fixer does not exist with this email", HttpStatus.BAD_REQUEST);
        }


        return ResponseEntity.ok(existFixer);
    }
}
