package racinggame.util;

public class StringUtils {

    private StringUtils() {}

    public static String repeat(final String str, final int num) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
