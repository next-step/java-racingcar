package calc;

import java.util.regex.Pattern;

public final class Matcher {

    private static final Pattern pattern = Pattern.compile("^(-?[\\d])([+-/*]\\d)*$");

    private Matcher() {}

    public static boolean matches(String expression) {
        if (expression == null || expression.length() == 0) {
            throw new IllegalArgumentException("expression must not be null");
        }

        java.util.regex.Matcher matcher = pattern.matcher(expression);

        return matcher.matches();
    }
}
