package com.example.petsmart.domain;

import lombok.Data;
import javax.validation.constraints.NotNull;

@Data
public class CreatePetRequest {
    @NotNull(message = "Name cannot be empty")
    String name;
    @NotNull(message = "Age cannot be empty")
    Integer age;
    @NotNull(message = "Pet type cannot be empty")
    String petType;
}
