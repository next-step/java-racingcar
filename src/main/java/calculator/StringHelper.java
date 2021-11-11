package calculator;

import java.util.Random;

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
}
