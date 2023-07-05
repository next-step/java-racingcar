package calculator.util;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean hasText(final String string) {
        return string != null && !string.isBlank();
    }

}
