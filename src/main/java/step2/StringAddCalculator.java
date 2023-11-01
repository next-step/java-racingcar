package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Integer ZERO = 0;
    private static final String COMMA_SEMICOLON = ",|;";
    private static final String MINUS = "-";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.)\\n(.*)");

    public static int splitAndSum(String input) {
        if (isInputNullOrBlank(input)) {
            return ZERO;
        }
        hasNegativeNumber(input);
        return splitNumbers(input);
    }

    private static boolean isInputNullOrBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return ZERO;
        }
    }

    private static int splitNumbers(String input) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] splitNumbers = matcher.group(2).split(customDelimiter);
            return sum(parseIntegerArray(splitNumbers));
        }

        String[] splitNumbers = input.split(COMMA_SEMICOLON);
        return sum(parseIntegerArray(splitNumbers));
    }

    private static int sum(int[] inputs) {
        int sum = 0;
        for (int num : inputs) {
            sum += num;
        }
        return sum;
    }

    private static int[] parseIntegerArray(String[] inputNumbers) {
        int[] result = new int[inputNumbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = parseInt(inputNumbers[i]);
        }
        return result;
    }

    private static void hasNegativeNumber(String input) {
        if (input.contains(MINUS)) {
            throw new RuntimeException("Negative number is not allowed.");
        }
    }
}
