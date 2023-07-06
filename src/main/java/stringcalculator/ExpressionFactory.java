package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionFactory {

    private static final String BASIC_DELIMITER = ":|,";
    private static final String CUSTOM_REGEX = "^//(.)\n(.*)";

    public static Expression create(String inputText) {
        if (inputText == null) {
            return new Expression("", BASIC_DELIMITER);
        }

        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(inputText);
        if (m.find()) {
            return new Expression(m.group(2), m.group(1));
        }

        return new Expression(inputText, BASIC_DELIMITER);
    }
}
