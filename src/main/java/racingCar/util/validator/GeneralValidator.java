package racingCar.util.validator;

public class GeneralValidator {
    private GeneralValidator() {
    }

    public static void validateDuplicateSubstring(String substring, String value, String message) {
        if (containsDuplicateSubstring(substring, value)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateStartSubstring(String substring, String value, String message) {
        if (value.startsWith(substring)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateEndSubstring(String substring, String value, String message) {
        if (value.endsWith(substring)) {
            throw new IllegalArgumentException(message);
        }
    }

    private static boolean containsDuplicateSubstring(String substring, String value) {
        String doubleSubstring = substring.repeat(2);
        return value.contains(doubleSubstring);
    }

}
