package racing.utils;

public class StringUtil {
    public static final String COMMA = ",";

    public static String[] splitCommas(String value) {
        return value.split(COMMA);
    }
}
