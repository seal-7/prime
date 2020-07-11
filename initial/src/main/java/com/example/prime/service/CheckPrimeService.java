package com.example.prime.service;

import org.springframework.stereotype.Service;

import com.example.prime.dto.CheckPrimeDTO;
import com.example.prime.dto.CheckPrimeResponseDTO;

@Service
public class CheckPrimeService {

    public CheckPrimeResponseDTO checkPrime(CheckPrimeDTO checkPrimeDTO) {

        boolean isPrime = isPrime(checkPrimeDTO.getNum());
        return new CheckPrimeResponseDTO(isPrime);
    }

    private boolean isPrime(int num) {
        if (num <= 1) {
            /* All number from -ve infinity till 1. */
            return false;
        }
        if(num < 4) {
            /* 2 and 3 are prime numbers. */
            return true;
        }
        if(num%2 == 0 || num%3 == 0) {
            /* Numbers which are divisible by 2 and 3 cannot be prime numbers. */
            return false;
        }
        for(int i=5; (i*i)<=num; i+=6) {
            /* Prime numbers are found in the form of 6n +1 or 6n - 1, where n > 0. So we will iterate till sqrt of num and check using this formula. */
            if((num%i) == 0 || (num%(i+2)) == 0) {
                return false;
            }
        }
        return true;
    }
}
