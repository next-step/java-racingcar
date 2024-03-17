package racing.utils;

import racing.Constant;

public class ValidationUtil {

    public static void validateInput(String names, int round) {
        if (names == null || names.isBlank() || !names.contains(",")) {
            throw new IllegalArgumentException(Constant.CAR_NUMBER_VALIDATION_ERROR);
        }

        if (names.split(",").length <= 1) {
            throw new IllegalArgumentException(Constant.CAR_NUMBER_VALIDATION_ERROR);
        }

        if (round <= 0) {
            throw new IllegalArgumentException(Constant.ROUND_NUMBER_VALIDATION_ERROR);
        }
    }
}
