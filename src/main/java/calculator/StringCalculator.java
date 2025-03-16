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
        if (isEmptyInput(input)) return 0;
        return sum(splitNumbers(input));
    }

    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += toInt(number);
        }
        return result;
    }

    private static boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
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
