package racinggame.utils;

public class StringUtils {

    private StringUtils() {
        throw new IllegalStateException("utility class");
    }

    public static boolean isBlank(final String text) {
        return text == null || text.trim().isEmpty();
    }

}
