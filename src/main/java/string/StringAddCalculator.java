package string;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    public static int splitAndSum(String text) {
        if (isEmpty(text)) {
            return 0;
        }
        int[] splitText = convertIntArray(text);
        existsNegative(splitText);
        return sum(splitText);
    }

    private static void existsNegative(int[] splitNumbers) {
        if (isNegative(splitNumbers)) {
            throw new RuntimeException();
        }
    }

    private static boolean isNegative(int[] splitNumbers) {
        return Arrays.stream(splitNumbers).anyMatch(n -> n < 0);
    }

    private static String[] splitText(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return text.split("[,:]");
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
