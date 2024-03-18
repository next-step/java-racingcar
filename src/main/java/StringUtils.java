import java.util.regex.Pattern;

public final class StringUtils {

    public static String[] split(String value, String delimeter) {
        return value.split(delimeter);
    }


    public static char chatAt(String value, int i) {
        return value.charAt(i);
    }

    public static boolean hasPattern(String pattern, String value) {
        Pattern p = Pattern.compile(pattern);
        return p.matcher(value).find();
    }
}
