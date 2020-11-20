package racingcar.util;

import static racingcar.common.Constant.BLANK;
import static racingcar.common.Constant.BLANK_STRING;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isBlank(String value){
        return value.equals(BLANK) || value.equals(BLANK_STRING) || value.isEmpty();
    }
}
