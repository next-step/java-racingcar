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

    public static void checkZeroOrMore(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("The number is less than zero. Please enter a number greater than 0.");
        }
    }

}
