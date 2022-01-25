package calculator.domain;

import java.util.regex.Pattern;

public class Validator {

    private static final Pattern EXPRESSION = Pattern.compile(
        "^(0|[1-9][0-9]*)(\\s*(([-+*]\\s*(0|[1-9][0-9]*))|([/]\\s*[1-9][0-9]*)))+$");

    public static boolean isValidExpression(String input) {
        return EXPRESSION.matcher(input).matches();
    }
}
