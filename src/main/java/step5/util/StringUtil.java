package step5.util;

public class StringUtil {
    public static boolean isEmpty(String value) {
        if (value == null) {
            return true;
        }
        return "".equals(value);
    }

    public static String[] stringSplit(String value, String delemeter) {
        return value.split(delemeter);
    }
}