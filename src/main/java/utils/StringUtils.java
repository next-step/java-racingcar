package utils;

public class StringUtils {

    private StringUtils() {
    }

    public static boolean isNumeric(String value) {
        return value.chars().allMatch(Character::isDigit);
    }
}
