package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String SEPARATOR = "[,;]";
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);

    private StringAddCalculator() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(split(text));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static int sum(String[] values) {
        PositiveNumber result = new PositiveNumber(0);
        for (String number : values) {
            result = result.plus(new PositiveNumber(number));
        }
        return result.getNumber();
    }

    private static String[] split(String text) {
        Matcher m = CUSTOM_SEPARATOR_PATTERN.matcher(text);
        if (m.find()) {
            return m.group(2).split(m.group(1));
        }
        return text.split(SEPARATOR);
    }
}