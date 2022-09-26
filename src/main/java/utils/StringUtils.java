package utils;

public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static boolean isPositiveNumeric(String value) {
        return value.chars().allMatch(Character::isDigit) && Integer.parseInt(value) >= 0;
    }
}
