package com.example.petsmart.domain;

import com.example.petsmart.constant.PetType;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CreatePetRequest {
    @NotNull(message = "Name cannot be empty")
    String name;
    @NotNull(message = "Age cannot be empty")
    Integer age;
    @NotNull(message = "Pet type cannot be empty")
    PetType petType;
}
