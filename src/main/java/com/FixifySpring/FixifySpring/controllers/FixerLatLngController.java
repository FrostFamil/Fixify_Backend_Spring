package com.FixifySpring.FixifySpring.controllers;

import com.FixifySpring.FixifySpring.models.FixerLatLng;
import com.FixifySpring.FixifySpring.service.FixerLatLngService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("api/v2/fixerLatLng")
@RestController
public class FixerLatLngController {

    private final FixerLatLngService fixerLatLngService;

    @Autowired
    public FixerLatLngController(FixerLatLngService fixerLatLngService) {
        this.fixerLatLngService = fixerLatLngService;
    }

    @PostMapping("/addFixersLocation")
    public ResponseEntity<?> addFixersLocation(@Validated @RequestBody FixerLatLng fixerLocationRequest){
        return fixerLatLngService.addFixersLocation(fixerLocationRequest);
    }
}
