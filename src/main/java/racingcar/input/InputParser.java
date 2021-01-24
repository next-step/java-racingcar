package racingcar.input;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static racingcar.ExceptionMessages.CAR_NAME_CANNOT_EXCEED_5_CHARACTERS;
import static racingcar.ExceptionMessages.NO_INPUT_VALUES;

public class InputParser {

    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private InputParser() {
    }

    public static List<String> parseCarNames(String carNamesInput) {
        validateNonBlank(carNamesInput);
        String[] carNames = carNamesInput.split(DELIMITER);
        List<String> trimmedCarNames = trim(carNames);
        for (String carName : trimmedCarNames) {
            validateLength(carName);
        }
        return trimmedCarNames;
    }

    private static void validateNonBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NO_INPUT_VALUES);
        }
    }

    private static List<String> trim(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateLength(final String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_EXCEED_5_CHARACTERS);
        }
    }
}