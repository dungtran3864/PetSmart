package com.example.petsmart.repository;

import com.example.petsmart.entity.Pet;

import java.util.List;

public interface PetRepositoryCustom {
    List<Pet> findPets(String petType, String name);
}
