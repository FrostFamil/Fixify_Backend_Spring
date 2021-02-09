package com.FixifySpring.FixifySpring.service;

import com.FixifySpring.FixifySpring.models.Fixer;
import com.FixifySpring.FixifySpring.models.FixerLatLng;
import com.FixifySpring.FixifySpring.repository.FixerLatLngRepository;
import com.FixifySpring.FixifySpring.repository.FixerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FixerLatLngService {

    @Autowired
    private FixerLatLngRepository fixerLatLngRepository;
    @Autowired
    private FixerRepository fixerRepository;

    public ResponseEntity<?> addFixersLocation(FixerLatLng fixerLocationRequest) {
        //fixer check
        Optional<Fixer> existFixer = fixerRepository.findFixerById(fixerLocationRequest.getCreator());
        Optional<FixerLatLng> existLocationForFixer = fixerLatLngRepository.findFixerLatLngByCreator(fixerLocationRequest.getCreator());
        if (existFixer.isEmpty()) {
            return new ResponseEntity<>("Fixer does not exist with this Id", HttpStatus.BAD_REQUEST);
        }

        //Check if location exist for this user and add or update based on existence
        if(existLocationForFixer.isEmpty()){
            fixerLatLngRepository.save(fixerLocationRequest);
            return ResponseEntity.ok(fixerLocationRequest);
        }
        else {
            existLocationForFixer.filter(p -> {
                p.setLatitude(fixerLocationRequest.getLatitude());
                p.setLongitude(fixerLocationRequest.getLongitude());
                p.setCreator(fixerLocationRequest.getCreator());
                return true;
            });
            fixerLatLngRepository.save(existLocationForFixer.get());
            return ResponseEntity.ok(existLocationForFixer);
        }
    }

}
