package util;

public class StringUtils {

    private static final String REGEX_NEGATIVE_NUMBER = "(.*)-\\d(.*)";

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean containsNegativeNumber(String str) {
        return str.matches(REGEX_NEGATIVE_NUMBER);
    }
}
