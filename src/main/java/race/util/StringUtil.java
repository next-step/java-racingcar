package race.util;

public class StringUtil {
    public static boolean isNullOrEmpty(String str) {
        if (str == null) {
            return true;
        }
        if (str.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
