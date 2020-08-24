package racingcar.utils;

import static racingcar.utils.Constants.NAME_LENGTH_MAX;
import static racingcar.utils.StringUtils.isNullOrBlank;

public class CarNameValidation {

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
