package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private InputParser() {
    }

    public static List<String> parseCarNames(String carNamesInput) {
        validateNonNull(carNamesInput);
        String[] carNames = carNamesInput.split(DELIMITER);
        List<String> trimmedCarNames = trim(carNames);
        for (String carName : trimmedCarNames) {
            validateLength(carName);
        }
        return trimmedCarNames;
    }

    private static void validateNonNull(String name) {
        if (name == null) { // TODO: isBlank() 구현
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private static List<String> trim(final String[] carNames) {
        return Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());
    }

    private static void validateLength(final String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}