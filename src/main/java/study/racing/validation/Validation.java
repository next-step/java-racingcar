package study.racing.validation;

import study.racing.common.Message;

public class Validation {

    public static final int MIN_NUMBER = 0;

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

    public static void checkValueLimitLength(String text, int limit){
        if(limit < text.length()){
            throw new IllegalArgumentException(Message.MSG_ERROR_VALUE_LIMIT_LENGTH);
        }
    }

    public static void checkName(String text, int limit) {
        checkNullValue(text);
        checkValueLimitLength(text,limit);
    }

    public static void checkMinimumNumber(int number){
        if(number < MIN_NUMBER){
            throw new IllegalArgumentException(Message.MSG_ERROR_IS_NOT_WHOLE_NUMBER);
        }
    }
}
