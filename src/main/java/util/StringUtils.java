package util;

public class StringUtils {
    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean containsNegativeNumber(String str) {
        return str.matches("(.*)-\\d(.*)");
    }
}
