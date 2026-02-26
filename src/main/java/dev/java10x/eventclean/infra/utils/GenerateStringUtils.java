package dev.java10x.eventclean.infra.utils;

import dev.java10x.eventclean.core.utils.GenerateStringUtilsCase;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.stereotype.Component;

@Component
public class GenerateStringUtils implements GenerateStringUtilsCase {

    @Override
    public String execute() {
        RandomStringGenerator generatorString = RandomStringGenerator.builder()
                .withinRange('a', 'z').build();
        RandomStringGenerator generatorNumber = RandomStringGenerator.builder()
                .withinRange('0', '9')
                .build();
        return String.format(generatorString.generate(4) + "-" + generatorNumber.generate(3)).toUpperCase();
    }
}
