package com.example.petsmart.service;

import com.example.petsmart.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {
}
