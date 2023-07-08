package racing.util;

public final class StringUtils {

    private StringUtils() {
    }

    public static boolean hasNotText(final String string) {
        return string == null || string.isBlank();
    }
}
