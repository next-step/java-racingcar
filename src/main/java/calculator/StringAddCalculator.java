package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    static final String SEPARATOR = ",|:";

    public static int splitAndSum(String text) {

        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = getMatcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] values = m.group(2).split(customDelimiter);

            return sum(values);
        }

        return separatorSum(text);
    }

    private static Matcher getMatcher(String text) {
        return Pattern.compile("//(.)\n(.*)").matcher(text);
    }

    private static int sum(String[] values) {
        int num = 0;
        for (String value : values) {
            validate(value);

            num += Integer.parseInt(value);
        }
        return num;
    }

    private static void validate(String value) {
        if (Integer.parseInt(value) < 0) {
            throw new RuntimeException();
        }
    }

    private static int separatorSum(String text) {
        String[] numbers = text.split(SEPARATOR);
        return sum(numbers);
    }

}
