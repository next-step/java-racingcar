package step4.utils;

public class StringUtils {
    public static boolean isBlank(String value) {
        return (value == null || value.trim().isEmpty()) ? true : false;
    }
}
