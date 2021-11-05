package utils;

import java.util.regex.Pattern;

public class IntUtils {
    private static final Pattern pattern = Pattern.compile("\\d+");
    private IntUtils() {}
    public static boolean isInt(String str) {
        return pattern.matcher(str).matches();
    }
}