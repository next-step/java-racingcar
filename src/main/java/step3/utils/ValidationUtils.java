package step3.utils;

public class ValidationUtils {

    public static void checkArgument(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkState(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalStateException(errorMessage);
        }
    }

    public static void checkPositive(Integer integer, String errorMessage) {
        if (integer == null || integer <= 0) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
