package utils;

public class StringUtils {
    private static final int ZERO = 0;
    private static final String COMMA = ",";

    private static class SettingsHolder {
        public static final StringUtils utils = new StringUtils();
    }

    private StringUtils() {
    }

    public static StringUtils getInstance() {
        return SettingsHolder.utils;
    }

    public static boolean isNullAndBlank(String sentence) {
        if (isNull(sentence)) return true;
        if (isBlank(sentence)) return true;
        return false;
    }

    private static boolean isNull(String sentence) {
        return sentence == null;
    }

    private static boolean isBlank(String sentence) {
        return sentence.trim().length() == ZERO;
    }



}
