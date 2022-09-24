package utils;

public class StringUtils {

    public StringUtils() {
    }

    public static boolean isNumeric(String value) {
        return value.chars().allMatch(Character::isDigit);
    }
}
