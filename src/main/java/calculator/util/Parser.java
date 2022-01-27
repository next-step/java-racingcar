package calculator.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private static final String DELIMITER = " ";

    public static List<String> splitExpression(String expression) {
        return Arrays.asList(expression.split(DELIMITER));
    }
}
