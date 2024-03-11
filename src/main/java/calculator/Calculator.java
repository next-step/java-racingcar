package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    private static final int ZERO = 0;
    public static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    public static int calculate(String input) {
        if (isBlank(input)) {
            return ZERO;
        }
        return sum(splitByCustomDelimiter(input));
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static String[] splitByCustomDelimiter(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
        if (m.find()) {
            return extractTokens(m);
        }
        return splitByDefault(input);
    }

    private static String[] extractTokens(Matcher m) {
        String customDelimiter = m.group(1);
        String[] tokens = m.group(2).split(customDelimiter);
        return tokens;
    }

    private static String[] splitByDefault(String input) {
        return input.split(DELIMITER);
    }

    private static int sum(String[] values) {
        int result = ZERO;
        for (String value : values) {
            result += toInt(value);
        }
        return result;
    }

    private static int toInt(String input) {
        return Integer.parseInt(input);
    }
}
