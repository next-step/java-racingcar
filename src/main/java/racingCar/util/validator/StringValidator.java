package racingCar.util.validator;

import java.util.Objects;
import java.util.regex.Pattern;

public class StringValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");

    private StringValidator() {
    }

    public static void validateBlank(String value, String message) {
        if (Objects.isNull(value)) {
            throw new IllegalArgumentException(message);
        }
        if (value.isBlank()) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateNumeric(String value, String message) {
        if (!isNumber(value)) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void validateIntegerRange(String value, String message) {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(message);
        }
    }

    public static boolean isNumber(String value) {
        return NUMBER_PATTERN.matcher(value).matches();
    }
}
