package com.example.petsmart.controller;

import com.example.petsmart.domain.CreatePetRequest;
import com.example.petsmart.domain.HTTPGenericResponse;
import com.example.petsmart.entity.Pet;
import com.example.petsmart.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
@AllArgsConstructor
public class PetController {

    private PetService petService;

    @GetMapping
    public ResponseEntity<List<Pet>> getPets(@RequestParam(required = false, name = "type") String petType) {
        return new ResponseEntity<>(petService.getPets(petType), HttpStatus.OK);
    }

    @GetMapping("/{petId}")
    public ResponseEntity<Pet> getPetById(@PathVariable String petId) {
        Optional<Pet> pet = petService.getPetById(petId);
        return pet.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    public ResponseEntity<HTTPGenericResponse> createPet(@Valid @RequestBody CreatePetRequest pet) {
        return new ResponseEntity<>(petService.createPet(pet), HttpStatus.OK);
    }
}
