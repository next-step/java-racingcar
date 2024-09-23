package calculator.utils;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBlank(final String text) {
        return text == null || text.trim().isEmpty();
    }

}
