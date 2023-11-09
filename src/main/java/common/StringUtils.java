package common;

public class StringUtils {
    private StringUtils() {
    }

    public static boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }
}
