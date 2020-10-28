package calc;

import java.util.regex.Pattern;

public final class Matcher {

    private static final Pattern pattern = Pattern.compile("^(-?[\\d])([+-/*]\\d)*$");

    private Matcher() {}

    public static boolean matches(String expression) {
        java.util.regex.Matcher matcher = pattern.matcher(expression);

        return matcher.matches();
    }
}
