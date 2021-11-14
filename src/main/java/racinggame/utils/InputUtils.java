package racinggame.utils;

import racinggame.domain.value.Names;
import racinggame.exception.NotInstanceException;
import racinggame.vo.InputValue;

import java.util.Arrays;
import java.util.List;

public class InputUtils {
    private static final String NAME_SEPARATOR = ",";

    private InputUtils() {
        throw new NotInstanceException();
    }

    public static InputValue convertInputValue(String carNames, String numberOfAttempts) {
        validate(carNames, numberOfAttempts);
        return InputValue.create(Names.createNames(extractNames(carNames)), convertInt(numberOfAttempts));
    }

    private static List<String> extractNames(String input) {
        return Arrays.asList(input.split(NAME_SEPARATOR));
    }

    private static int convertInt(String value) {
        return Integer.parseInt(value);
    }

    private static void validate(String carNames, String numberOfAttempts) {
        InputValidator.validateNullAndEmptySource(carNames);
        InputValidator.validateAttempts(numberOfAttempts);
    }

}
