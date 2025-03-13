package utils;

import exception.UtilInstantiationException;

public class StringUtils {

    private StringUtils() {
        throw new UtilInstantiationException();
    }

    public static boolean hasText(String value) {
        return value == null || value.isBlank();
    }

    public static boolean hasNotText(String value) {
        return !hasText(value);
    }
}
