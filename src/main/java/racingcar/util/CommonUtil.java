package racingcar.util;

public class CommonUtil {

    public static void checkNullEmpty(String str) {
        checkNullEmpty(str, null);
    }

    public static void checkNullEmpty(String str, String exceptionMessage) {
        String defaultExceptionMessage = "Argument is null or empty.";
        if(str == null || str.isEmpty()) {
            throw new IllegalArgumentException(exceptionMessage == null ? defaultExceptionMessage : exceptionMessage);
        }
    }

}
