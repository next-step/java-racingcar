package calculator.view;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;


public class ExpressionValidator {

    public static final String EXPRESSION_PATTERN = "^([0-9]+\\s[\\+\\-\\*\\/]\\s)+[0-9]+$";

    public static boolean validate(String expression) {
        //null | empty check
        if (StringUtils.isEmpty(expression)) {
            return false;
        }

        //expression check
        if (!Pattern.matches(EXPRESSION_PATTERN, expression)) {
            return false;
        }

        return true;
    }

}
