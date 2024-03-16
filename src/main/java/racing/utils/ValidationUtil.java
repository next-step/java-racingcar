package racing.utils;

import racing.Constant;

import java.util.Arrays;

public class ValidationUtil {

    public static void validateInput(String names, int round) {
        validateLength(names, round);
        validateCarNameLength(names);
    }

    private static void validateLength(String names, int round) {
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

    private static void validateCarNameLength(String names) {
        Boolean isLengthOverFive = Arrays.stream(names.split(",")).anyMatch(name -> name.length() > 5);
        if (isLengthOverFive) {
            throw new IllegalArgumentException(Constant.CAR_NAME_LENGTH_VALIDATION_ERROR);
        }
    }

}
