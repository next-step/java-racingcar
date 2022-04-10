package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DELIMITER = "[,:]";

    public static int splitAndSum(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return calculate(matcher.group(2), customDelimiter);
        }
        return calculate(input, DELIMITER);
    }

    private static int calculate(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .map(StringNumber::new)
                .mapToInt(StringNumber::getNumber)
                .sum();
    }
}
