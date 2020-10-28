package calc;

import java.util.regex.Pattern;

public final class Matcher {

    private static final Pattern pattern = Pattern.compile("^([+-]?[\\d]+)([+-/*]\\d+)*$");

    private Matcher() {
    }

    public static void matches(String expression) {
        java.util.regex.Matcher matcher = pattern.matcher(expression);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("invalid expression");
        }
    }
}
