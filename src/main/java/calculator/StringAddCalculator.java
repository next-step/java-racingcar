package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static Integer splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return compileSeparator(text);
    }

    private static int compileSeparator(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens= m.group(2).split(customDelimiter);
            validateNegativeNumber(tokens);
            return getSumNumber(tokens);
        }
        return Integer.parseInt(text);
    }

    private static void validateNegativeNumber(String[] tokens) {
        long count = Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .filter(number -> number < 0)
                .count();
        if (count > 0) {
            throw new RuntimeException();
        }
    }

    private static int getSumNumber(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
