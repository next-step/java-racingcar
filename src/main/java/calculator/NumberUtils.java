package calculator;

public class NumberUtils {

    public static boolean isInteger(String number) {
        try {
            Long.parseLong(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNotInteger(String number) {
        return !isInteger(number);
    }
}
