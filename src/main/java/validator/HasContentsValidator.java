package validator;

import exception.EmptyException;

public class HasContentsValidator {

    private static boolean isNull(String input) {
        return input == null;
    }

    private static boolean isBlank(String input) {
        return input.trim().length() == 0;
    }

    public static void validate(String input) {
        if (isNull(input) || isBlank(input)) {
            throw new EmptyException();
        }
    }
}
