package utils;

import java.util.regex.Pattern;

public class IntUtils {
    private IntUtils() {}
    public static boolean isInt(String str) {
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(str).matches();
    }
}