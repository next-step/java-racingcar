package calculator;

import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");
    public static boolean isNumeric(String value) {
        return NUMERIC_PATTERN.matcher(value).matches();
    }

    public static boolean isNotNumeric(String value) {
        return !isNumeric(value);
    }
}
