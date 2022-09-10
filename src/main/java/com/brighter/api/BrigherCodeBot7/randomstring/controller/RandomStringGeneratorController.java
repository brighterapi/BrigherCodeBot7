package com.brighter.api.BrigherCodeBot7.randomstring.controller;

import com.brighter.api.BrigherCodeBot7.randomstring.RandomStringGeneratorService;
import com.brighter.api.BrigherCodeBot7.randomstring.dto.GeneratorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class RandomStringGeneratorController {

    @Autowired
    private RandomStringGeneratorService randomStringGeneratorService;

    @GetMapping(value = "/v1/randomGenerator", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneratorDto> generator(@RequestHeader Map<String, String> headers, @RequestParam(defaultValue = "alphanumeric") String type, @RequestParam(defaultValue = "3") int minlength, @RequestParam(defaultValue = "15") int maxlength) {
        return randomStringGeneratorService.generate(headers, type, minlength, maxlength);
    }
}
