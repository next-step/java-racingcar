package calculator.domain;

import java.util.regex.Pattern;

public class Validator {

    public static final Pattern VALID_EXPRESSION = Pattern.compile("^\\d+(\\s*[-+*/]\\s*\\d+)+$");

    public static boolean checkValidate(String expression) {
        return VALID_EXPRESSION.matcher(expression).matches();
    }
}
