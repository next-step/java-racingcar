package racingcar.model.utils.common;


import static racingcar.model.utils.info.RacingGameErrorInfo.CAR_NAME_DUPLICATED_ERROR;
import static racingcar.model.utils.info.RacingGameErrorInfo.CAR_NAME_LIMIT_ERROR;
import static racingcar.model.utils.info.RacingGameErrorInfo.TRY_NUMBER_COUNT_ERROR;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.utils.exception.InputValidationException;

public class Validation {

    public static boolean parsingCarName(String name) {
        try {
            validateLengthLimit(StringUtils.splitStr(name));
            validateDuplicateCar(StringUtils.splitStr(name));
        } catch (InputValidationException exception) {
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }

    public static boolean parsingRacingTry(int count) {
        try {
            validateNumberRange(count);
        } catch (InputValidationException exception) {
            System.out.println(exception.getMessage());
            return true;
        }
        return false;
    }

    private static void validateNumberRange(final int number) {
        if (number < 1 || number > 9) {
            throw new InputValidationException(TRY_NUMBER_COUNT_ERROR);
        }
    }

    private static void validateLengthLimit(final List<String> splitUserInput) {
        boolean match = splitUserInput.stream()
            .allMatch(input -> input.length() <= 5 && input.length() >= 1);
        if (!match) {
            throw new InputValidationException(CAR_NAME_LIMIT_ERROR);
        }
    }

    private static void validateDuplicateCar(final List<String> splitUserInput) {
        int size = splitUserInput.stream().distinct().collect(Collectors.toList()).size();

        if (size != splitUserInput.size()) {
            throw new InputValidationException(CAR_NAME_DUPLICATED_ERROR);
        }
    }

}
