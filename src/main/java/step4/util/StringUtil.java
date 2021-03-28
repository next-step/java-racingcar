package step4.util;

public class StringUtil {
    private StringUtil() {
    }

    public static boolean isBlank(String str) {
        return (str == null || str.trim().isEmpty());
    }

    public static String[] splite(String data, String separator) {
        return data.split(separator);
    }
}
