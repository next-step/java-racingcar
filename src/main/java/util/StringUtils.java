package util;

import calculator.ExceptionMessage;

public class StringUtils {

    public static boolean isBlank(String input) {
        return input == null || input.replace(" ", "").equals("");
    }

    public static boolean validateNumber(String string) {
        if (isBlank(string)) {
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
        if (!validateNumber(string)) {
            throw new IllegalArgumentException(string + ExceptionMessage.INVALID_INPUT_NUMBER);
        }
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
