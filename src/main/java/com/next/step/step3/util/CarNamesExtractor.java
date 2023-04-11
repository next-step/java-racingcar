package com.next.step.step3.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarNamesExtractor {

    private static final String CAR_NAME_DELIMITER = ",";

    private CarNamesExtractor() {
    }

    public static List<String> extractCarNames(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
                .collect(Collectors.toList());
    }
}
