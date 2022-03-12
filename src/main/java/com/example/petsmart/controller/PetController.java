package com.example.petsmart.controller;

import com.example.petsmart.domain.CreatePetRequest;
import com.example.petsmart.domain.HTTPGenericResponse;
import com.example.petsmart.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @GetMapping
    public ResponseEntity<List> getPets() {
        return new ResponseEntity<>(petService.getPets(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HTTPGenericResponse> createPet(@Valid @RequestBody CreatePetRequest pet) {
        return new ResponseEntity<>(petService.createPet(pet), HttpStatus.OK);
    }
}
