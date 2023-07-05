package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringExpressionFactory {

    public static StringExpression create(String inputText) {
        if (inputText == null) {
            return new StringExpression("", ":|,");
        }

        Matcher m = Pattern.compile("^//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            return new StringExpression(m.group(2), m.group(1));
        }

        return new StringExpression(inputText, ":|,");
    }

}
