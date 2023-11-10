package com.example.petsmart.service;

import com.example.petsmart.domain.CreatePetRequest;
import com.example.petsmart.domain.HTTPGenericResponse;
import com.example.petsmart.entity.Pet;

import java.util.List;
import java.util.Optional;

public interface PetService {
    HTTPGenericResponse createPet(CreatePetRequest createPetRequest);
    List<Pet> getPets();

    Optional<Pet> getPetById(String id);
}
