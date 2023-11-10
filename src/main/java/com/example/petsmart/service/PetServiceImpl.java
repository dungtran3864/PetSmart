package com.example.petsmart.service;

import com.example.petsmart.domain.CreatePetRequest;
import com.example.petsmart.domain.HTTPGenericResponse;
import com.example.petsmart.entity.Pet;
import com.example.petsmart.repository.PetRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PetServiceImpl implements PetService {

    private PetRepository petRepository;

    @Override
    public HTTPGenericResponse createPet(CreatePetRequest createPetRequest) {
        Pet pet = Pet.builder().name(createPetRequest.getName()).age(createPetRequest.getAge()).petType(createPetRequest.getPetType()).build();
        try {
            petRepository.save(pet);
            return HTTPGenericResponse.builder().message("Created pet successfully").statusCode(HttpStatus.OK).build();
        } catch (Exception exception) {
            throw new RuntimeException("Failed to create pet");
        }
    }

    @Override
    public List<Pet> getPets(String petType) {
        return petRepository.findPets(petType);
    }

    @Override
    public Optional<Pet> getPetById(String id) {
        return petRepository.findById(Integer.valueOf(id));
    }
}
