package step2.util;

import static step2.common.ExceptionMessage.ILLEGAL_ARGS_NULL;

public class StringUtils {

    private static final String SPACE = " ";
    private static final String STRING_NULL = "";

    public static String[] splitInputValBySpace(String inputVal) {
        if(inputVal == null || inputVal.equals(STRING_NULL)) throw new IllegalArgumentException(ILLEGAL_ARGS_NULL);
        return inputVal.split(SPACE);
    }

}
