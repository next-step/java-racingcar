package racingcar.utils;

import static racingcar.utils.StringUtils.isNullOrBlank;

public class CarNameValidation {

    public static final int NAME_LENGTH_MAX = 5;

    public static boolean isValid(String input) {
        if (isNullOrBlank(input)) {
            return false;
        }
        if (input.length() > NAME_LENGTH_MAX) {
            return false;
        }
        return true;
    }
}
