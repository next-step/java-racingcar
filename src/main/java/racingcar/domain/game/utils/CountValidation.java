package racingcar.domain.game.utils;

import static racingcar.domain.game.utils.Constants.*;

public class CountValidation {

    public static int checkNumber(int number) {
        if (number < VALID_MIN_NUMBER) {
            throw new RuntimeException(number + ERROR_ZERO_OR_NEGATIVE);
        }
        return number;
    }
}
