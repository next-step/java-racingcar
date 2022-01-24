package calculator.util;

public class Parser {

    private static final String DELIMITER = " ";

    public static String[] splitExpression(String expression) {
        return expression.split(DELIMITER);
    }
}
