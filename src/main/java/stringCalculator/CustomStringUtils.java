package stringCalculator;

import stringCalculator.exception.EmptyException;
import stringCalculator.exception.NullException;

public class CustomStringUtils {

    public static String[] split(String str) {
        validateNone(str);
        return str.split(" ");
    }

    private static void validateNone(String str) {
        if (str == null) {
            throw new NullException();
        }

        if (str.isEmpty()) {
            throw new EmptyException();
        }
    }
}
