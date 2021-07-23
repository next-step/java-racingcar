package study.racing.validation;

import study.racing.common.Message;

public class Validation {

    public static void checkValue(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException(Message.MSG_ERROR_VALUE_NULL_BLANK);
        }
    }

}
