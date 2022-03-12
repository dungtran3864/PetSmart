package com.example.petsmart.domain;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HTTPGenericResponse {
    private HttpStatus statusCode;
    private String message;
}
