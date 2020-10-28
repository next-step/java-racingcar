package calc;

import java.util.regex.Pattern;

public final class Matcher {

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("^([+-]?[\\d]+)([+-/*]\\d+)*$");

    private Matcher() {
    }

    public static void matches(String expression) {
        java.util.regex.Matcher matcher = EXPRESSION_PATTERN.matcher(expression);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("invalid expression");
        }
    }
}
