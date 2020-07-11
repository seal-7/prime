package com.example.prime.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.prime.dto.CheckPrimeDTO;
import com.example.prime.dto.CheckPrimeResponseDTO;
import com.example.prime.service.CheckPrimeService;

@Controller
@RequestMapping("/v1")
public class CheckPrimeController {
    private final String CHECK_PRIME = "check/prime";
    private final CheckPrimeService checkPrimeService;

    @Autowired
    public CheckPrimeController(final CheckPrimeService checkPrimeService) {
        this.checkPrimeService = checkPrimeService;
    }

    @GetMapping(path = CHECK_PRIME, produces = "application/json", params = "value")
    private ResponseEntity<CheckPrimeResponseDTO> checkPrime(@RequestParam("value") Integer value) {
        CheckPrimeDTO checkPrimeDTO = new CheckPrimeDTO(value);
        CheckPrimeResponseDTO responseDTO = checkPrimeService.checkPrime(checkPrimeDTO);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

}
