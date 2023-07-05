package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpressionFactory {

    private static final String BASIC_DELIMITER = ":|,";
    private static final String CUSTOM_REGEX = "^//(.)\n(.*)";

    public static StringExpression create(String inputText) {
        if (inputText == null) {
            return new StringExpression("", BASIC_DELIMITER);
        }

        Matcher m = Pattern.compile(CUSTOM_REGEX).matcher(inputText);
        if (m.find()) {
            return new StringExpression(m.group(2), m.group(1));
        }

        return new StringExpression(inputText, BASIC_DELIMITER);
    }

}
