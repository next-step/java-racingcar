package racingcar.utils;

import racingcar.exception.CarNameEmptyException;
import racingcar.exception.CarNameOverSizeException;

import java.util.Arrays;

public class ValidateUtil {
    private static boolean validateCarNamesLength(String[] carNames) {
        return Arrays.stream(carNames).noneMatch(e -> e.length() > 5);
    }

    public static void validateCarNames(String[] carNames) {
        if (carNames == null || carNames.length < 1) {
            throw new CarNameEmptyException();
        }

        if (!validateCarNamesLength(carNames)) {
            throw new CarNameOverSizeException();
        }

    }
}
