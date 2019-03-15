package util;

public class StringUtils {

    public static boolean isNullOrEmpty(String s) {
        return s == null || s.length() <= 0;
    }

    public static boolean isNullOrEmptyArray(String[] strArray) {
        return strArray == null || strArray.length <= 0;
    }

    public static String repeat(String string, int count) {
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < count; ++i ) {
            sb.append(string);
        }
        return sb.toString();
    }

}
