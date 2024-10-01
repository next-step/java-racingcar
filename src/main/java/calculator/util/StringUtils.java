package calculator.util;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean hasText(String str) {
        return str != null && !str.trim().isEmpty();
    }
}
