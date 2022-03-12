package com.example.petsmart.service;

import com.example.petsmart.domain.CreatePetRequest;
import com.example.petsmart.domain.HTTPGenericResponse;

public interface PetService {
    HTTPGenericResponse create(CreatePetRequest createPetRequest);
}
