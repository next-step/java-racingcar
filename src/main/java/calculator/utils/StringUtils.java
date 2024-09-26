package calculator.utils;

public class StringUtils {

    private StringUtils() {}

    public static boolean isBlank(final String text) {
        return text == null || text.trim().isEmpty();
    }

    public static boolean isNumeric(final String text) {
        if (isBlank(text)) {
            return false;
        }
        return text.matches("-?\\d+(\\.\\d+)?");
    }

}
