package calculator;

import java.util.regex.*;

public class StringAddCalculator {

    private static String SEPARATOR = ",|:";
    private static String CUSTOM_SEPARATOR_PATTERN = "\"//(.)\\n(.*)\"";
    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }

        int number = customSplit(text);

        return number;
    }

    private static int customSplit(String text) {
        Pattern pattern = Pattern.compile(CUSTOM_SEPARATOR_PATTERN);
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            return calculateByMatcher(matcher);
        }

        return calculate(text);
    }

    private static int calculate(String text) {
        String[] numbers = text.split(SEPARATOR);

        if (numbers.length == 1) {
            return parseInt(text);
        }

        return sum(numbers);
    }

    private static int calculateByMatcher(Matcher m) {
        return sum(m.group(2).split(m.group(1)));
    }

    private static int sum(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            result += parseInt(number);
        }

        return result;
    }

    private static int parseInt(String number) {
        int result = Integer.parseInt(number);

        if (result < 0) {
            throw new RuntimeException("negative number");
        }

        return result;
    }

}
