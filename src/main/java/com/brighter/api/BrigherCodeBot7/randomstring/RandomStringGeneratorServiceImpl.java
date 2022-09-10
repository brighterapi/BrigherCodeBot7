package com.brighter.api.BrigherCodeBot7.randomstring;

import com.brighter.api.BrigherCodeBot7.randomstring.dto.GeneratorDto;
import org.apache.commons.lang3.EnumUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@Component
public class RandomStringGeneratorServiceImpl implements RandomStringGeneratorService {

    private static final Logger logger = LoggerFactory.getLogger(RandomStringGeneratorServiceImpl.class);

    @Override
    public ResponseEntity<GeneratorDto> generate(Map<String, String> headers, String type, int minValue, int maxValue) {
        logger.info("Random String Request====> {} == {} == {} == {}  ", headers, type, minValue, maxValue);
        GeneratorDto generatorDto = new GeneratorDto();
        generatorDto.setMaxlength(maxValue);
        generatorDto.setMinlength(minValue);
        generatorDto.setType(type.toLowerCase());


        validateRequest(type, minValue, maxValue);
        RandomStringGeneratorEnum randomStringGeneratorEnum = EnumUtils.getEnum(RandomStringGeneratorEnum.class, type.toLowerCase());

        switch (randomStringGeneratorEnum) {
            case alphabetic:
                generatorDto.setValue(RandomStringUtils.randomAlphabetic(minValue, maxValue));
                break;
            case numeric:
                generatorDto.setValue(RandomStringUtils.randomNumeric(minValue, maxValue));
                break;
            case alphanumeric:
                generatorDto.setValue(RandomStringUtils.randomAlphanumeric(minValue, maxValue));
                break;
            case alphanumericspecial:
                generatorDto.setValue(RandomStringUtils.randomPrint(minValue, maxValue));
                break;
            default:
                logger.error("Invalid Request Type Internal Server error {} ", type);
                generatorDto.setValue("invalid type");
                return ResponseEntity.internalServerError().body(generatorDto);
        }

        return ResponseEntity.ok(generatorDto);
    }

    private void validateRequest(String type, int minLength, int maxLength) {
        if (!EnumUtils.isValidEnumIgnoreCase(RandomStringGeneratorEnum.class, type)) {
            logger.error("Invalid Request Type {} ", type );
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Request Type.");
        }

        if(minLength > maxLength){
            logger.error("minlength value must be smaller or equal to maxlength value. {} {} ", minLength , maxLength );
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "minlength value must be smaller or equal to maxlength value.");
        }

        if(minLength > 5000 || maxLength > 5000){
            logger.error("minlength and maxlength value must be less than 5000. {} {} ", minLength , maxLength );
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "minlength and maxlength value must be less than 5000.");
        }
    }

}
