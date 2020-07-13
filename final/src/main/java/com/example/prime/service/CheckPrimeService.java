package com.example.prime.service;

import org.springframework.stereotype.Service;

import com.example.prime.dto.CheckPrimeDTO;
import com.example.prime.dto.response.CheckPrimeResponseDTO;
import com.example.prime.enums.ServiceError;
import com.example.prime.exception.NotPrimeException;

@Service
public class CheckPrimeService {

    public CheckPrimeResponseDTO checkPrime(CheckPrimeDTO checkPrimeDTO) throws NotPrimeException {

        throwIfNotPrime(checkPrimeDTO.getNum());
        return new CheckPrimeResponseDTO(true);
    }

    private void throwIfNotPrime(int num) throws NotPrimeException {
        if (num <= 1) {
            /* All number from -ve infinity till 1. */
            throw new NotPrimeException(ServiceError.NOT_A_PRIME_NUMBER);
        }
        if(num < 4) {
            /* 2 and 3 are prime numbers. */
            return;
        }
        if(num%2 == 0 || num%3 == 0) {
            /* Numbers which are divisible by 2 and 3 cannot be prime numbers. */
            throw new NotPrimeException(ServiceError.NOT_A_PRIME_NUMBER);
        }
        for(int i=5; (i*i)<=num; i+=6) {
            /* Prime numbers are found in the form of 6n +1 or 6n - 1, where n > 0. So we will iterate till sqrt of num and check using this formula. */
            if((num%i) == 0 || (num%(i+2)) == 0) {
                throw new NotPrimeException(ServiceError.NOT_A_PRIME_NUMBER);
            }
        }
    }
}
