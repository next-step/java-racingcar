package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String value) {
        if (isaBlank(value)) {
            return 0;
        }

        String[] numbers = getText(value).split(getSeparator(value));
        return sum(numbers);
    }

    private static String getText(String value) {
        Matcher matcher = getMatcher(value);

        if (!matcher.find()) {
            return value;
        }

        return matcher.group(2);
    }

    private static String getSeparator(String value) {
        Matcher matcher = getMatcher(value);

        if (!matcher.find()) {
            return value;
        }

        return matcher.group(1);
    }

    private static Matcher getMatcher(String value) {
        return Pattern.compile("//(.)\n(.*)").matcher(value);
    }

    private static int sum(String[] numbers) {
        int result = 0;

        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                throw new RuntimeException();
            }
            result += Integer.parseInt(number);
        }
        return result;
    }

    private static boolean isaBlank(String value) {
        return value == null || value.isBlank();
    }
}
