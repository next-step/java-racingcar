package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        return sum(toPositives(split(text)));
    }

    private static String[] split(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(DELIMITER);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static Positive[] toPositives(String[] values) {
        Positive[] numbers = new Positive[values.length];
        for (int i = 0; i < values.length; i++) {
            Positive number = new Positive(values[i]);
            numbers[i] = number;
        }
        return numbers;
    }

    private static int sum(Positive[] numbers) {
        Positive result = new Positive(0);
        for (Positive number : numbers) {
            result = result.plus(number);
        }
        return result.getNumber();
    }

}
