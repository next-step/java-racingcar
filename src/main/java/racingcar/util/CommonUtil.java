package racingcar.util;

public class CommonUtil {

    private final static String DEFAULT_EXCEPTION_MESSAGE = "Argument is null or empty.";

    public static void checkNullEmpty(String str) {
        checkNullEmpty(str, null);
    }

    public static void checkNullEmpty(String str, String exceptionMessage) {
        if(str == null || str.isEmpty()) {
            throw new IllegalArgumentException(exceptionMessage == null ? DEFAULT_EXCEPTION_MESSAGE : exceptionMessage);
        }
    }

    public static void checkZeroOrMore(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("The number is less than zero. Please enter a number greater than 0.");
        }
    }

}
