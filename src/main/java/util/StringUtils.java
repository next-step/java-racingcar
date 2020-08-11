package util;

import exception.ExceptionMessage;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        if (string == null) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_INPUT_STRING);
        }

        return IntStream.range(0, repeat)
                .mapToObj(i -> string)
                .collect(Collectors.joining(""));
    }
}
