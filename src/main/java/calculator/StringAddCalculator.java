package calculator;

import java.util.Arrays;

import static calculator.util.StringUtils.hasText;

public class StringAddCalculator {

    private StringAddCalculator() {
        throw new IllegalStateException("Utility class");
    }

    private static final String REGEX_COMMA_OR_COLON = "[,:]";
    private static final String PREFIX = "//";
    private static final String SUFFIX = "\n";

    public static int splitAndSum(String input) {
        if (!hasText(input)) {
            return 0;
        }
        return sum(makeArray(input));
    }

    private static int sum(String[] array) {
        return Arrays.stream(array)
                .mapToInt(StringAddCalculator::parseIntOrThrow)
                .sum();
    }

    private static int parseIntOrThrow(String str) {
        var num = Integer.parseInt(str);
        if (num < 0) throw new RuntimeException();
        return num;
    }

    private static String[] makeArray(String input) {
        if (isCustomDelimiter(input)) {
            var delimiter = makeCustomDelimiter(input);
            var customInput = makeCustomInput(input);
            return customInput.split(delimiter);
        }
        return input.split(REGEX_COMMA_OR_COLON);
    }

    private static String makeCustomInput(String input) {
        return input.substring(input.indexOf(SUFFIX) + SUFFIX.length());
    }

    private static String makeCustomDelimiter(String input) {
        return input.substring(input.indexOf(PREFIX) + PREFIX.length(),
                input.indexOf(SUFFIX));
    }

    private static boolean isCustomDelimiter(String input) {
        return input.contains(PREFIX) && input.contains(SUFFIX);
    }
}
