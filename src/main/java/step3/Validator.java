package step3;

import java.util.Arrays;

public class Validator {
    private static final int LIMIT_CAR_NAME_LENGTH = 5;

    public static boolean isValidateCarsNameLength(String[] carsName) {
        return Arrays.stream(carsName)
                .allMatch(str -> str.length() <= LIMIT_CAR_NAME_LENGTH);
    }
}
