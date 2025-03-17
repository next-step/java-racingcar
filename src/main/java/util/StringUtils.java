package util;

public class StringUtils {
    public static boolean isBlank(String csv) {
        return csv == null || csv.trim().isEmpty();
    }
}
