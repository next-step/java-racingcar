package calculator.utils;

import java.util.regex.Pattern;

public class StringUtils {
    private static final Pattern NUMERIC_PATTERN = Pattern.compile("-?\\d+");

    private StringUtils() {}

    public static boolean isEmpty(String string) {
        return string == null || string.isEmpty();
    }

    public static boolean isNumeric(String string) {
        return NUMERIC_PATTERN.matcher(string)
                .matches();
    }
}
