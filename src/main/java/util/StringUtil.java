package util;

public class StringUtil {

    private StringUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean isBlank(String str) {
        if (str == null || str.isEmpty() || str.trim().length() < 1) {
            return true;
        }
        return false;
    }
}
