package racing.utils;

import java.util.regex.Pattern;

public class ExpressionPattern {
    private static final Pattern EXPRESSION = Pattern.compile("[^0-9+\\-*/]");
    private static final Pattern NUMBER = Pattern.compile("[^0-9]");

    public static boolean isExpression(String s) {
        return EXPRESSION.matcher(s).matches();
    }

    public static boolean isNumber(String s) {
        return NUMBER.matcher(s).matches();
    }
}