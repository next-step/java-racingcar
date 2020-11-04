public class StringUtils {

    public static boolean isNullOrBlank(String value) {
        if (value == null) return true;
        if (value.isEmpty()) return true;
        for (int i = 0; i < value.length(); i++) {
            if (!Character.isWhitespace(value.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
