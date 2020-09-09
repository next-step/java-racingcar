package step3.utils;

import step3.common.ExceptionMessage;

public class ValidationUtils {

    public static final int NAME_SIZE = 5;

    public static boolean validationName(String name) {
        if(StringUtils.isBlank(name)) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NAME_UNAVAILABLE);
        }
        if(name.length() > NAME_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_NAME_UNAVAILABLE);
        }
        return true;
    }
}
