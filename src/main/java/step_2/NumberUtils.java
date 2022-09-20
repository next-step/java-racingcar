package step_2;

public class NumberUtils {
    private NumberUtils() {}

    public static int parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
