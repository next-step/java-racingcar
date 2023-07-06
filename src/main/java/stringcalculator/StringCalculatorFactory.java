package stringcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculatorFactory {

    private static final String DEFAULT_DELIMITER = ":|,";
    private static final String EMPTY_EXPRESSION = "";

    public static StringCalculator create(String inputText) {
        if (inputText == null) {
            return new StringCalculator(EMPTY_EXPRESSION, DEFAULT_DELIMITER);
        }

        Matcher m = Pattern.compile("^//(.)\n(.*)").matcher(inputText);
        if (m.find()) {
            return new StringCalculator(m.group(2), m.group(1));
        }

        return new StringCalculator(inputText, DEFAULT_DELIMITER);
    }

}
