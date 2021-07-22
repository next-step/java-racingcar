package study.racing.validation;

import study.racing.common.Message;

public class Validation {

    public static void checkValue(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.MSG_ERROR_VALUE_NULL_BLANK);
        }
    }
}
