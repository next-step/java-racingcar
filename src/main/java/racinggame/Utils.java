package racinggame;

public class Utils {

    private Utils() {}

    public static String repeat(final String str, final int num) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
