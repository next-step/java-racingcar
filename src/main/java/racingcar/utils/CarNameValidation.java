package racingcar.utils;

import static racingcar.utils.StringUtils.isNullOrBlank;

public class CarNameValidation {

    public static boolean isValid(String input) {
        if (isNullOrBlank(input)) {
            return false;
        }
        if (input.length() > 5) {
            return false;
        }
        return true;
    }
}
