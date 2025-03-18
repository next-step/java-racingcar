package racingcar.util;

import racingcar.view.InputView;

import static racingcar.message.ErrorMessage.POSITIVE_NUMBER;

public class InputValidator {

    public static int validatePositiveNumber(String input) {
        int number = InputView.convertToInt(input);
        validatePositive(number);
        return number;
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(POSITIVE_NUMBER);
        }
    }
}
