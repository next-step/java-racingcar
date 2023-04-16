package racing;

public class StringValidator {
    public static boolean isLessThanEqualLen(String value, int len) {
        return value.length() <= len;
    }

    public static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

}
