package racingcar;

import java.util.List;

public class InputParser {

    private static final String DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private InputParser() {
    }

    public static List<String> parseCarNames(String input) {
        validateNonNull(input);
        String[] carNames = input.split(DELIMITER);
        for (String carName : carNames) {
            validateLength(carName);
        }
        return List.of(carNames);
    }

    private static void validateNonNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }
    }

    private static void validateLength(final String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
    }
}