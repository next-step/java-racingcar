package calculator;

import static java.math.BigInteger.ZERO;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StringAddCalculator {

    private static final Pattern customDelimiterRegexPattern = Pattern.compile("//(.)\n(.*)");
    private static final int DELIMITER_INDEX = 1;
    private static final int EXPRESSION_INDEX = 2;
    private static final String STANDARD_DELIMITER = ",|:";

    private StringAddCalculator() {
    }

    public static BigInteger splitAndSum(final String text) {
        if (isNullOrBlank(text)) {
            return ZERO;
        }

        return sum(toOperands(split(text)));
    }

    private static boolean isNullOrBlank(final String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String expression) {
        final Matcher customDelimiterMatcher = customDelimiterRegexPattern.matcher(expression);

        if (customDelimiterMatcher.find()) {
            final String customDelimiter = customDelimiterMatcher.group(DELIMITER_INDEX);
            expression = customDelimiterMatcher.group(EXPRESSION_INDEX);

            return expression.split(customDelimiter);
        }

        return expression.split(STANDARD_DELIMITER);
    }

    private static List<Operand> toOperands(final String[] tokens) {
        return Arrays.stream(tokens)
                .map(Operand::from)
                .collect(Collectors.toList());
    }

    private static BigInteger sum(final List<Operand> operands) {
        return operands.stream()
                .map(Operand::value)
                .reduce(ZERO, BigInteger::add);
    }
}
