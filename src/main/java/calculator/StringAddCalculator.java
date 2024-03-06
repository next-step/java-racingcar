package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {

    private static final String SPECIFIED_DELIMITER_REGEX = ",|:";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }

        final String[] operands = getOperands(text);

        return Arrays.stream(operands)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static String[] getOperands(final String text) {
        final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        final Matcher matcher = pattern.matcher(text);

        if (!matcher.find()) {
            return text.split(SPECIFIED_DELIMITER_REGEX);
        }

        final String customDelimiter = matcher.group(1);
        final String expression = matcher.group(2);

        return expression.split(customDelimiter);
    }
}
