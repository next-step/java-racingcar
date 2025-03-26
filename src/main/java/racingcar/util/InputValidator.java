package racingcar.util;

import racingcar.view.InputView;

import java.util.List;

import static racingcar.message.ErrorMessage.INVALID_NAME;
import static racingcar.message.ErrorMessage.POSITIVE_NUMBER;
import static racingcar.view.OutputView.SEPERATOR;

public class InputValidator {

    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private InputValidator() {
    }

    public static int validatePositiveNumber(String input) {
        int number = InputView.convertToInt(input);

        validatePositive(number);

        return number;
    }

    private static void validatePositive(int number) {
        if (isLessThanMinimumLength(number)) {
            throw new IllegalArgumentException(POSITIVE_NUMBER);
        }
    }

    private static boolean isLessThanMinimumLength(int number) {
        return number < MINIMUM_NAME_LENGTH;
    }

    public static List<String> validateNames(String input) {
        List<String> names = List.of(input.split(SEPERATOR));

        return validateName(names);
    }

    private static List<String> validateName(List<String> names) {
        boolean hasInvalidName = checkInvalidName(names);

        if (hasInvalidName) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        return List.copyOf(names);
    }

    private static boolean checkInvalidName(List<String> names) {
        return names.stream()
                .anyMatch(name -> name.isBlank() || name.length() > MAXIMUM_NAME_LENGTH);
    }
}
