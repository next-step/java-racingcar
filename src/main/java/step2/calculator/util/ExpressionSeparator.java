package step2.calculator.util;

import java.util.Arrays;
import java.util.List;

public class ExpressionSeparator {
    private static final String SEPARATOR = " ";

    private ExpressionSeparator() {
        throw new AssertionError();
    }

    public static List<String> split(final String expression) {
        return Arrays.asList(expression.split(SEPARATOR));
    }
}
