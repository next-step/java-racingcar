package calculator.util;

public class StringUtils {
    private StringUtils() {

    }
    public static String[] splitExpression(String expression) {
        return expression.split(" ");
    }
}
