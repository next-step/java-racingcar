package step2;

public class StringUtil {
    public static boolean isNumber(String str) {
        return str.matches("(^[0-9]*$)");
    }

    public static String[] doSplit(String input, String key) {
        String[] result;
        try {
            result = input.split(key);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return result;
    }
}
