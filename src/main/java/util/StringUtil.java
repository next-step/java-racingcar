package util;

public class StringUtil {
    private StringUtil() {
    }

    public static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }
}
