package step5.client.util;


public class StringUtils {
    private StringUtils() {
        throw new AssertionError();
    }

    public static boolean isBlank(final String str) {
        int strLen;
        if (str == null || (strLen = str.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if ((Character.isWhitespace(str.charAt(i)) == Boolean.FALSE)) {
                return false;
            }
        }
        return true;
    }
}
