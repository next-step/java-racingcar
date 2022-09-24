package racingCar.exception;

import java.text.MessageFormat;

public class ExceptionMessageUtil {
    private static final String OUT_OF_BOUNDED = "범위를 벗어난 값입니다. (범위 : {0} ~ {1} )";

    private ExceptionMessageUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static String outOfBoundedException(int min, int max) {
        return MessageFormat.format(OUT_OF_BOUNDED, new Object[]{min, max});
    }
}
