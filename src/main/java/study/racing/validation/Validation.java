package study.racing.validation;

import study.racing.common.Message;

public class Validation {

    public static final int LIMIT_LENGTH = 5;

    public static void checkValue(Integer input) {
        if (input == null) {
            throw new IllegalArgumentException(Message.MSG_ERROR_VALUE_NULL_BLANK);
        }
    }

    public static void checkNullValue(String text) {
        if (text == null || text.trim().isEmpty()) {
            throw new IllegalArgumentException(Message.MSG_ERROR_VALUE_NULL_BLANK);
        }
    }

    public static void checkValueLimitLength(String text){
        if(LIMIT_LENGTH < text.length()){
            throw new IllegalArgumentException(Message.MSG_ERROR_VALUE_LIMIT_LENGTH);
        }
    }

    public static void checkName(String text) {
        checkNullValue(text);
        checkValueLimitLength(text);
    }
}
