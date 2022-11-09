package racingcar.utils;

import racingcar.exception.CarNameDuplicateException;
import racingcar.exception.CarNameEmptyException;
import racingcar.exception.CarNameOverSizeException;

import java.util.Arrays;

public class ValidateUtil {
    private static boolean validateCarNamesLength(String[] carNames) {
        return Arrays.stream(carNames).anyMatch(e -> e.length() > 5);
    }

    private static boolean validateCarNamesDuplicate(String[] carNames) {
        return Arrays.stream(carNames).distinct().count() != carNames.length;
    }

    public static void validateCarNames(String[] carNames) throws CarNameEmptyException, CarNameOverSizeException, CarNameDuplicateException {
        if (carNames == null || carNames.length < 1) {
            throw new CarNameEmptyException();
        }

        if (validateCarNamesLength(carNames)) {
            throw new CarNameOverSizeException();
        }

        if (validateCarNamesDuplicate(carNames)) {
            throw new CarNameDuplicateException();
        }

    }
}
