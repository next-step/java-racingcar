package utils;

public class StringUtils {

    private static class SettingsHolder {
        public static final StringUtils utils = new StringUtils();
    }

    private StringUtils() {
    }

    public static StringUtils getInstance() {
        return SettingsHolder.utils;
    }

    public static boolean isNullAndBlank(String expression) {
        if (isNull(expression)) return true;
        if (isBlank(expression)) return true;
        return false;
    }

    private static boolean isNull(String expression) {
        return expression == null;
    }

    private static boolean isBlank(String expression) {
        return expression.trim().length() == 0;
    }


}
