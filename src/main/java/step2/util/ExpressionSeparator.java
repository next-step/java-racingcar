package step2.util;

import java.util.Arrays;
import java.util.List;

public class ExpressionSeparator {
    private static final String SEPARATOR = " ";

    public static List<String> split(final String expression) {
        return Arrays.asList(expression.split(SEPARATOR));
    }
}
