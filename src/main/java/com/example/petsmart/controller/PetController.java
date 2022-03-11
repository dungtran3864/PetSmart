package com.example.petsmart.controller;

import com.example.petsmart.model.Pet;
import com.example.petsmart.service.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    private PetRepository petRepository;

    @PostMapping
    public @ResponseBody String createPet(@RequestBody Pet pet) {
        petRepository.save(pet);
        return "Saved";
    }

    @GetMapping("/")
    public Pet getPet() {
        return Pet.builder().name("Kitty").age(5).build();
    }
}
