package utils;

import exception.UtilInstantiationException;

public class StringUtils {

    private StringUtils() {
        throw new UtilInstantiationException();
    }

    public static boolean isNullOrEmpty(String value) {
        return value == null || value.isBlank();
    }
}
