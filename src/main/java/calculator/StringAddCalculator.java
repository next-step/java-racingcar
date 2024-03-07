package calculator;

import static java.math.BigInteger.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class StringAddCalculator {

    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final String STANDARD_DELIMITER = ",|:";

    private StringAddCalculator() {
    }

    public static BigInteger splitAndSum(final String text) {
        if (isNullOrBlank(text)) {
            return ZERO;
        }

        final String[] tokens = split(text);

        final List<Operand> operands = Arrays.stream(tokens)
                .map(Operand::from)
                .collect(Collectors.toList());

        return sum(operands);
    }

    private static boolean isNullOrBlank(final String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String expression) {
        final Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_REGEX);
        final Matcher matcher = pattern.matcher(expression);

        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            expression = matcher.group(2);

            return expression.split(customDelimiter);
        }

        return expression.split(STANDARD_DELIMITER);
    }

    private static BigInteger sum(final List<Operand> operands) {
        return operands.stream()
                .map(Operand::value)
                .reduce(ZERO, BigInteger::add);
    }
}
