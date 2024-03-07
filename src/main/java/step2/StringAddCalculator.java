package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String DELIMITER = ",|:";

    public static int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return ZERO;
        }

        String[] values = isSplitUsingCustomization(input) ? splitWithCustomization(input) : splitWithDelimiter(input);

        return sum(toInts(values));
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private static boolean isSplitUsingCustomization(String input) {
        return input.startsWith("//") && input.contains("\n");
    }

    private static String[] splitWithCustomization(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return tokens;
        }

        return new String[]{};
    }

    private static String[] splitWithDelimiter(String input) {
        return input.split(DELIMITER);
    }

    private static int[] toInts(String[] values) {
        int length = values.length;
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = toInt(values[i]);
        }

        return numbers;
    }

    private static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch(NumberFormatException exception) {
            String error = String.format("Invalid delimiter used : %s", value);
            throw new RuntimeException(error);
        }
    }

    private static int sum(int[] numbers) {
        int result = ZERO;

        for (int number : numbers) {
            checkForNegative(number);
            result += number;
        }

        return result;
    }

    private static void checkForNegative(int number) {
        if (number < ZERO) {
            String error = String.format("Negative number is not allowed : %s", number);
            throw new RuntimeException(error);
        }
    }
}
