package utils;

import exception.UtilInstantiationException;

public class NumberUtils {

    private static final int ZERO = 0;

    private NumberUtils() {
        throw new UtilInstantiationException();
    }

    public static boolean isNumber(String value) {
        if (StringUtils.hasText(value)) {
            return false;
        }
        return value.chars()
            .allMatch(Character::isDigit);
    }

    public static boolean isNotNumber(String value) {
        return !isNumber(value);
    }

    public static boolean isNegativeNumber(int value) {
        return value < ZERO;
    }

    public static boolean isPositiveNumber(int value) {
        return value > ZERO;
    }

    public static boolean isZero(int value) {
        return value == ZERO;
    }


}
