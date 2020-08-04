package calculator.util;

import calculator.ExceptionMessage;

public class StringUtils {

    public static boolean isBlank(String input) {
        return input == null || input.replace(" ", "").equals("");
    }

    public static boolean isNumeric(String string) {
        if (string == null) {
            return false;
        }
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    public static double getNumber(String string) {
        if (isNumeric(string)) {
            return Double.parseDouble(string);
        }
        throw new IllegalArgumentException(string + ExceptionMessage.INVALID_INPUT_NUMBER);
    }
}
