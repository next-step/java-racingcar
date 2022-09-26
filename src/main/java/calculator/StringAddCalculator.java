package calculator;

import exception.NegativeNumberException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String COMMA_SEPARATOR = "[,:]";
    private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }
        int[] numbers = toInts(split(text));

        return sum(numbers);
    }

    private static boolean isBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static String[] split(String text) {
        Matcher matcher = PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return matcher.group(2).split(customDelimiter);
        }

        return text.split(COMMA_SEPARATOR);
    }

    private static int[] toInts(String[] values){
        return Arrays.stream(values)
            .mapToInt(Integer::parseInt)
            .map(StringAddCalculator::checkPositiveNumber)
            .toArray();
    }

    private static int checkPositiveNumber(int num) {
        if (num < 0) {
            throw new NegativeNumberException();
        }
        return num;
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

}
