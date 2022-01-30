package racingcar.view;

import static racingcar.common.SystemMessage.CAR_NAME_DUPLICATE_ERROR;
import static racingcar.common.SystemMessage.CAR_NAME_LENGTH_LIMIT_ERROR;

import java.util.List;
import racingcar.common.exception.InputValidationException;

public class Validator {

    private static final int LENGTH_LIMIT_MAX = 5;
    private static final int LENGTH_LIMIT_MIN = 1;

    private Validator() {
    }

    protected static void validateLengthLimit(final List<String> splitUserInput) {
        boolean match = splitUserInput.stream().allMatch(
            input -> input.length() <= LENGTH_LIMIT_MAX && input.length() >= LENGTH_LIMIT_MIN);

        if (!match) {
            throw new InputValidationException(CAR_NAME_LENGTH_LIMIT_ERROR);
        }
    }

    protected static void validateDuplicateCar(final List<String> splitUserInput) {
        int size = (int) splitUserInput.stream().distinct().count();

        if (size != splitUserInput.size()) {
            throw new InputValidationException(CAR_NAME_DUPLICATE_ERROR);
        }
    }

}
