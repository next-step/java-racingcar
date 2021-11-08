package step3.utils;

public class ValidationUtils {

    private static final int MIN_POSITIVE_VALUE = 0;

    public static void checkArgument(boolean expression, String errorMessage) {
        if (!expression) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void checkPositive(Integer value, String errorMessage) {
        if (value == null || value < MIN_POSITIVE_VALUE) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
