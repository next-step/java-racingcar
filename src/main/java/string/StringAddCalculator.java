package string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String CUSTOM_SPLIT_REGEX = "//(.)\n(.*)";
    private static final Pattern COMPILED_PATTERN = Pattern.compile(CUSTOM_SPLIT_REGEX);
    private static final String COMMA_COLON_REGEX = "[,:]";

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        int[] numbers = convertIntArray(text);
        existsNegativeNumber(numbers);
        return sum(numbers);
    }

    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static int[] convertIntArray(String text) {
        return Arrays.stream(splitText(text))
                .mapToInt(StringAddCalculator::convertNumber)
                .toArray();
    }

    private static String[] splitText(String text) {
        Matcher m = COMPILED_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split(COMMA_COLON_REGEX);
    }

    private static int convertNumber(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IncludeNotNumberException(text);
        }
    }

    private static void existsNegativeNumber(int[] splitNumbers) {
        if (isNegativeNumber(splitNumbers)) {
            throw new ExistsNegativeNumberException();
        }
    }

    private static boolean isNegativeNumber(int[] splitNumbers) {
        return Arrays.stream(splitNumbers).anyMatch(n -> n < 0);
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers)
            .sum();
    }

}
