package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final int ZERO = 0;
    private static final String DELIMITER = ",|:";
    private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

    private static final String OUT_OF_BOUND_ERROR = "Negative number is not allowed : ";
    private static final String INVALID_DELIMITER_ERROR = "Invalid delimiter used : ";
    private static final String UNEXPECTED_CUSTOM_DELIMITER_ERROR = "Unexpected Custom Delimiter used : ";

    public int splitAndSum(String input) throws Exception {
        if (isNullOrBlank(input)) {
            return ZERO;
        }

        String[] values = isSplitUsingCustomization(input) ? splitWithCustomization(input) : splitWithDelimiter(input);

        return sum(toInts(values));
    }

    private boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private boolean isSplitUsingCustomization(String input) {
        return input.startsWith("//") && input.contains("\n");
    }

    private String[] splitWithCustomization(String input) throws Exception {
        Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);

        try {
            if (matcher.find()) {
                String customDelimiter = matcher.group(1);
                String[] tokens = matcher.group(2).split(customDelimiter);
                return tokens;
            }
        } catch (Exception exception) {
            throw new Exception(UNEXPECTED_CUSTOM_DELIMITER_ERROR + input);
        }

        return new String[]{};
    }

    private String[] splitWithDelimiter(String input) {
        return input.split(DELIMITER);
    }

    private int[] toInts(String[] values) {
        int length = values.length;
        int[] numbers = new int[length];

        for (int i = 0; i < length; i++) {
            numbers[i] = toInt(values[i]);
        }

        return numbers;
    }

    private int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch(RuntimeException exception) {
            throw new RuntimeException(INVALID_DELIMITER_ERROR + value);
        }
    }

    private int sum(int[] numbers) {
        int result = ZERO;

        for (int number : numbers) {
            checkForNegative(number);
            result += number;
        }

        return result;
    }

    private void checkForNegative(int number) {
        if (number < ZERO) {
            throw new RuntimeException(OUT_OF_BOUND_ERROR + number);
        }
    }
}
