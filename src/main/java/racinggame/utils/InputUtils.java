package racinggame.utils;

import racinggame.InputValue;
import racinggame.exception.NotInstanceException;

import java.util.Arrays;
import java.util.List;

public class InputUtils {

    private InputUtils() {
        throw new NotInstanceException();
    }

    public static InputValue convertInputValue(String carNames, String numberOfAttempts) {
        validate(carNames, numberOfAttempts);
        return InputValue.create(extractToList(carNames), convertInt(numberOfAttempts));
    }

    private static int convertInt(String value) {
        return Integer.parseInt(value);
    }

    private static List<String> extractToList(String carNames) {
        String[] names = carNames.split(",");
        return Arrays.asList(names);
    }

    private static void validate(String carNames, String numberOfAttempts) {
        InputValidator.validateCarNames(carNames);
        InputValidator.validateAttempts(numberOfAttempts);
    }

}
