package racingcar.domain.game.utils;

import static racingcar.domain.game.utils.Constants.*;
import static racingcar.domain.game.utils.StringUtils.isNullOrBlank;

public class CarNameValidation {

    public static String checkName(String input) {
        if (isNullOrBlank(input)) {
            throw new RuntimeException(input + ERROR_NULL_OR_BLANK);
        }
        if (input.length() > NAME_LENGTH_MAX) {
            throw new RuntimeException(input + ERROR_NAME_LENGTH_OVER);
        }
        return input;
    }
}
