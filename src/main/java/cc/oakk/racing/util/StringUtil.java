package cc.oakk.racing.util;

import java.util.Arrays;
import java.util.List;

public class StringUtil {
    public static final String EMPTY_STRING = "";

    private StringUtil() {}

    public static boolean isEmpty(String value) {
        return value == null || value.trim().equals(EMPTY_STRING);
    }

    public static boolean isLengthGreaterThanOrEqual(String value, int number) {
        return value.length() >= number;
    }

    public static List<String> split(String value, String delimiter) {
        return Arrays.asList(value.split(delimiter));
    }
}
