package calculator.util;

public class StringUtils {

    private static final String DELIMITER = " ";

    private StringUtils() {
    }

    public static String[] splitExpression(String expression) {
        return expression.split(DELIMITER);
    }
}
