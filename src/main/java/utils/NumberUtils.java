package utils;

import exception.UtilInstantiationException;

public class NumberUtils {

    private NumberUtils() {
        throw new UtilInstantiationException();
    }

    public static boolean isNumber(String value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return false;
        }
        return value.chars()
            .allMatch(Character::isDigit);
    }
}
