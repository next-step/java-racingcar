package racingcar.model.utils.common;


import static racingcar.model.utils.info.RacingGameErrorInfo.CAR_NAME_DUPLICATED_ERROR;
import static racingcar.model.utils.info.RacingGameErrorInfo.CAR_NAME_LIMIT_ERROR;
import static racingcar.model.utils.info.RacingGameErrorInfo.TRY_NUMBER_COUNT_ERROR;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.utils.exception.InputValidationException;


public class Validation {

    private static final int START_NUMBER = 1;
    private static final int LAST_NUMBER = 9;
    private static final int LIMIT_NUMBEr = 5;

    public static boolean validateNumberRange(final int number) {
        try {
            if (number < START_NUMBER || number > LAST_NUMBER) {
                throw new InputValidationException(TRY_NUMBER_COUNT_ERROR);
            }
        } catch (InputValidationException exception) {
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }

    public static void validateLengthLimit(final List<String> splitUserInput) {
        boolean match = splitUserInput.stream()
            .allMatch(input -> input.length() <= LIMIT_NUMBEr && input.length() >= START_NUMBER);
        if (!match) {
            throw new InputValidationException(CAR_NAME_LIMIT_ERROR);
        }
    }

    public static void validateDuplicateCar(final List<String> splitUserInput) {
        int size = splitUserInput.stream().distinct().collect(Collectors.toList()).size();

        if (size != splitUserInput.size()) {
            throw new InputValidationException(CAR_NAME_DUPLICATED_ERROR);
        }
    }

}
