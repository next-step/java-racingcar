package helper;

/**
 * @author han
 */
public class StringHelper {

    public static boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }

    public static void throwExceptionIfNullOrEmpty(String input) {
        if (isNullOrEmpty(input)) {
            throw new IllegalArgumentException();
        }
    }

    public static void throwExceptionNullOrLengthGreaterThan(String input, int length) {
        if (input == null || input.length() > length) {
            throw new IllegalArgumentException();
        }
    }
}
