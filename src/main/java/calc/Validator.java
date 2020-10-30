package calc;

import java.util.regex.Pattern;

import static calc.ErrorMessage.INVALID_EXPRESSION;

public final class Validator {

    private static final Pattern EXPRESSION_PATTERN = Pattern.compile("^([+-]?[\\d]+)([+-/*]\\d+)*$");

    private Validator() {
    }

    public static void validate(String expression) {
        java.util.regex.Matcher matcher = EXPRESSION_PATTERN.matcher(expression);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_EXPRESSION);
        }
    }
}
