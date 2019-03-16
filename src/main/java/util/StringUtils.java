package util;

import java.util.List;

public class StringUtils {

    public static boolean isEmpty(String s) {
        return s == null || s.length() <= 0;
    }

    public static boolean isEmpty(List<String> strs) {
        return strs == null || strs.size() <= 0;
    }

    public static boolean isEmpty(String[] strs) {
        return strs == null || strs.length <= 0;
    }

    public static String repeat(String string, int count) {
        StringBuilder sb = new StringBuilder();
        for( int i = 0; i < count; ++i ) {
            sb.append(string);
        }
        return sb.toString();
    }

}
