package camp.nextstep.edu.util;

public final class StringUtils {
    private StringUtils() {
    }

    public static boolean isEmpty(String string) {
        return string == null || "".equals(string);
    }
}
