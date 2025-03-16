package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final String REGEX = "//(.)\n(.*)";

    public static int toInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

    public static int calculate(String input) {
        int result = 0;
        String[] numbers = splitNumbers(input);
        for (String number : numbers) {
            result += toInt(number);
        }
        return result;
    }

    private static String[] splitNumbers(String input) {
        Matcher m = Pattern.compile(REGEX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }
}
