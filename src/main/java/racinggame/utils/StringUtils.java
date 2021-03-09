package racinggame.utils;

public class StringUtils {
    public static boolean isBlank(String value) {
        if (value == null || value.isEmpty()) {
            return true;
        }
        return value.trim().isEmpty();
    }

    public static String repeat(int repeat, String delimeter) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < repeat; i++) {
            sb.append(delimeter);
        }
        return sb.toString();
    }
}
