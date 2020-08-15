package racingcar.exception;

import racingcar.constant.Constant;
import racingcar.constant.ExceptionMessage;

public final class ExceptionHandler {


    public static void validate(String name) {
        validateNameLength(name);
        isBlank(name);
        isNull(name);
    }

    public static void validateNameLength(String name) {
        if (name.length() > Constant.MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_CAN_NOT_EXCEED_FIVE_CHARACTERS);
        }
    }

    public static void isBlank(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_CAN_BE_NOT_EMPTY);
        }
    }

    public static void isNull(String name) {
        if (name == null) {
            throw new NullPointerException(ExceptionMessage.INPUT_CAN_BE_NOT_NULL);
        }
    }
}
