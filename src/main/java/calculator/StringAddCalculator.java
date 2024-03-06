package calculator;

import java.util.Arrays;

public final class StringAddCalculator {

    private static final String SPECIFIED_DELIMITER_REGEX = ",|:";

    private StringAddCalculator() {
    }

    public static int splitAndSum(final String expression) {
        if (expression == null || expression.isBlank()) {
            return 0;
        }

        final String[] operands = expression.split(SPECIFIED_DELIMITER_REGEX);

        return Arrays.stream(operands)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
