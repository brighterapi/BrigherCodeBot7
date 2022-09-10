package com.brighter.api.BrigherCodeBot7.randomstring;

import com.brighter.api.BrigherCodeBot7.randomstring.dto.GeneratorDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface RandomStringGeneratorService {

    ResponseEntity<GeneratorDto> generate(Map<String, String> headers, String type, int minValue, int maxValue);

}
