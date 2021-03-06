package com.example.prime.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CheckPrimeResponseDTO {

    @JsonProperty("is_prime")
    boolean isPrime;

    public CheckPrimeResponseDTO(final boolean isPrime) {
        this.isPrime = isPrime;
    }
}
