package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String delimiter = ",|:";
    private static final Pattern customDelimiterPattern = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {

    }

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        String[] numbers = split(text);
        return sum(numbers);
    }

    public static boolean isEmpty(String text) {
        return text == null || text.isEmpty();
    }

    public static String[] split(String text) {
        Matcher m = customDelimiterPattern.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(delimiter);
    }

    public static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            validationCheck(number);

            result += Integer.parseInt(number);
        }
        return result;
    }

    private static void validationCheck(String number) {
        if (!PositiveNumberFormatChecker.validationCheck(number)) {
            throw new NumberFormatException();
        }
    }
}
