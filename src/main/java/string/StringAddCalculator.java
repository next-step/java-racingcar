package string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static final String CUSTOM_SPLIT_REGEX = "//(.)\n(.*)";
    public static final String COMMA_COLON_REGEX = "[,:]";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        int[] numbers = convertIntArray(text);
        existsNegativeNumber(numbers);
        return sum(numbers);
    }

    private static void existsNegativeNumber(int[] splitNumbers) {
        if (isNegativeNumber(splitNumbers)) {
            throw new RuntimeException();
        }
    }

    private static boolean isNegativeNumber(int[] splitNumbers) {
        return Arrays.stream(splitNumbers).anyMatch(n -> n < 0);
    }

    private static String[] splitText(String text) {
        Matcher m = Pattern.compile(CUSTOM_SPLIT_REGEX).matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(COMMA_COLON_REGEX);
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers)
            .sum();
    }

    private static int[] convertIntArray(String text) {
        return Arrays.stream(splitText(text))
            .mapToInt(StringAddCalculator::convertNumber)
            .toArray();
    }

    private static int convertNumber(String text) {
        int result = 0;
        try {
            result = Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IncludeNotNumberException(text);
        }
        return result;
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

}
