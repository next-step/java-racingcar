package step2.util;

import static step2.common.ExceptionMessage.ILLEGAL_ARGS_NULL;

public class StringUtils {

    private static final String STRING_SPACE = " ";
    private static final String STRING_EMPTY = "";

    public static String[] splitInputValBySpace(String inputVal) {
        if(inputVal == null || inputVal.equals(STRING_EMPTY)) throw new IllegalArgumentException(ILLEGAL_ARGS_NULL);
        return inputVal.split(STRING_SPACE);
    }

}
