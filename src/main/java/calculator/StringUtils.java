package calculator;

public class StringUtils {
    public static boolean isInteger(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (Exception ignored) {}
        return false;
    }
}
