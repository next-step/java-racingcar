package step2;

public class StringUtils {

    public static boolean isNullOrBlank(String value) {
        if (value == null) return true;
        if (value.isEmpty()) return true;
        return !value.chars().anyMatch( ch -> !Character.isWhitespace(ch) );
    }
}
