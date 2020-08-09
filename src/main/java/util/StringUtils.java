package util;

import calculator.ExceptionMessage;

public class StringUtils {

    public static boolean isBlank(String input) {
        return input == null || input.trim().equals("");
    }

    public static void validateNumber(String string) {
        if (isBlank(string)) {
            throw new IllegalArgumentException(string + ExceptionMessage.INVALID_EMPTY_INPUT_NUMBER);
        }
        try {
            Double.parseDouble(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(string + ExceptionMessage.INVALID_FORMAT_INPUT_NUMBER);
        }
    }

    public static double getNumber(String string) {
        validateNumber(string);

        return Double.parseDouble(string);
    }

    public static String repeat(String string, int repeat) {
        if (string == null || repeat <= 0) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder(repeat);

        for (int i = 0; i < repeat; ++i) {
            stringBuilder.append(string);
        }

        return stringBuilder.toString();
    }
}
