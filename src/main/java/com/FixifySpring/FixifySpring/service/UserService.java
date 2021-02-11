package com.FixifySpring.FixifySpring.service;

import com.FixifySpring.FixifySpring.RequestResponseFiles.CardAddingRequest;
import com.FixifySpring.FixifySpring.RequestResponseFiles.LoginRequest;
import com.FixifySpring.FixifySpring.RequestResponseFiles.UpdateProfileRequest;
import com.FixifySpring.FixifySpring.models.Fixer;
import com.FixifySpring.FixifySpring.models.User;
import com.FixifySpring.FixifySpring.repository.FixerRepository;
import com.FixifySpring.FixifySpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
        //hashing password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //user check
        Optional<User> existUser = repository.findUserByEmail(user.getEmail());
        if (!existUser.isEmpty()) {
            return new ResponseEntity<>("User exist with this email", HttpStatus.BAD_REQUEST);
        }

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repository.save(user);
        return new ResponseEntity<>("User added", HttpStatus.CREATED);
    }

    public ResponseEntity<?> fixerSignup(Fixer fixer){
        //hashing password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //fixer check
        Optional<Fixer> existFixer = fixerRepository.findFixerByEmail(fixer.getEmail());
        if (!existFixer.isEmpty()) {
            return new ResponseEntity<>("Fixer exist with this email", HttpStatus.BAD_REQUEST);
        }

        fixer.setPassword(bCryptPasswordEncoder.encode(fixer.getPassword()));
        fixerRepository.save(fixer);
        return new ResponseEntity<>("Fixer added", HttpStatus.CREATED);
    }

    public ResponseEntity<?> userLogin(LoginRequest loginRequest) {
        //hashing password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //user check
        Optional<User> existUser = repository.findUserByEmail(loginRequest.getEmail());
        if (existUser.isEmpty()) {
            return new ResponseEntity<>("User does not exist with this email", HttpStatus.BAD_REQUEST);
        } else if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), existUser.get().getPassword())) {
            return new ResponseEntity<>("Password does not match", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existUser);
    }

    public ResponseEntity<?> fixerLogin(LoginRequest loginRequest) {
        //hashing password
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        //fixer check
        Optional<Fixer> existFixer = fixerRepository.findFixerByEmail(loginRequest.getEmail());
        if (existFixer.isEmpty()) {
            return new ResponseEntity<>("Fixer does not exist with this email", HttpStatus.BAD_REQUEST);
        } else if (!bCryptPasswordEncoder.matches(loginRequest.getPassword(), existFixer.get().getPassword())) {
            return new ResponseEntity<>("Password does not match", HttpStatus.BAD_REQUEST);
        }


        return ResponseEntity.ok(existFixer);
    }

    public ResponseEntity<?> getUserProfile(String email) {
        //user check
        Optional<User> existUser = repository.findUserByEmail(email);
        if (existUser.isEmpty()) {
            return new ResponseEntity<>("User does not exist with this email", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existUser);
    }

    public ResponseEntity<?> getFixerProfile(String email) {
        //fixer check
        Optional<Fixer> existFixer = fixerRepository.findFixerByEmail(email);
        if (existFixer.isEmpty()) {
            return new ResponseEntity<>("Fixer does not exist with this email", HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(existFixer);
    }

    public ResponseEntity<?> updateUserProfile(UpdateProfileRequest user) {
        //user check
        Optional<User> existUser = repository.findUserByEmail(user.getEmail());
        if (existUser.isEmpty()) {
            return new ResponseEntity<>("User does not exist with this email", HttpStatus.BAD_REQUEST);
        }

        existUser.filter(p -> {
            p.setEmail(user.getEmail());
            p.setFirstName(user.getFirstName());
            p.setLastName(user.getLastName());
            p.setPhone(user.getPhone());
            return true;
        });
        repository.save(existUser.get());

        return ResponseEntity.ok(existUser);
    }

    public ResponseEntity<?> updateFixerProfile(UpdateProfileRequest fixer) {
        //fixer check
        Optional<Fixer> existFixer = fixerRepository.findFixerByEmail(fixer.getEmail());
        if (existFixer.isEmpty()) {
            return new ResponseEntity<>("Fixer does not exist with this email", HttpStatus.BAD_REQUEST);
        }

        existFixer.filter(p -> {
            p.setEmail(fixer.getEmail());
            p.setFirstName(fixer.getFirstName());
            p.setLastName(fixer.getLastName());
            p.setPhone(fixer.getPhone());
            return true;
        });
        fixerRepository.save(existFixer.get());

        return ResponseEntity.ok(existFixer);
    }
}
