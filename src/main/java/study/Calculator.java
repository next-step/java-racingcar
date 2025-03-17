package study;

import java.util.regex.Pattern;

public class Calculator {
    public static int sum(String numbersWithDelimiter) {
        if (numbersWithDelimiter == null || numbersWithDelimiter.isBlank()) {
            return 0;
        }

        NumberDelimiterParser result = new NumberDelimiterParser(numbersWithDelimiter);
        return add(parseNonNegativeInts(split(result.numbers, result.delimiter)));
    }

    private static class NumberDelimiterParser {
        private static final String DEFAULT_NUMBERS_DELIMITER_REGEX = "[,:]";
        private static final String CUSTOM_DELIMITER_PREFIX = "//";
        private static final String NEW_LINE = "\n";

        public final String delimiter;
        public final String numbers;

        public NumberDelimiterParser(String numbersWithDelimiter) {
            int delimiterEnd = numbersWithDelimiter.indexOf(NEW_LINE);
            this.delimiter = computeDelimiter(numbersWithDelimiter, delimiterEnd);
            this.numbers = extractStringToSplit(numbersWithDelimiter, delimiterEnd);
        }

        private static String computeDelimiter(String numbersWithDelimiter, int delimiterEnd) {
            if (numbersWithDelimiter.startsWith(CUSTOM_DELIMITER_PREFIX)) {
                return Pattern.quote(numbersWithDelimiter.substring(2, delimiterEnd));
            }
            return DEFAULT_NUMBERS_DELIMITER_REGEX;
        }

        private static String extractStringToSplit(String numbersWithDelimiter, int delimiterEnd) {
            if (numbersWithDelimiter.startsWith(CUSTOM_DELIMITER_PREFIX)) {
                return numbersWithDelimiter.substring(delimiterEnd + 1);
            }
            return numbersWithDelimiter;
        }
    }

    private static String[] split(String numbers, String delimiter) {
        return numbers.split(delimiter);
    }

    private static int[] parseNonNegativeInts(String[] numberStrings) {
        int[] numbers = new int[numberStrings.length];
        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = parseNonNegativeInt(numberStrings[i]);
        }
        return numbers;
    }

    private static int parseNonNegativeInt(String numberStrings) {
        int num = Integer.parseInt(numberStrings);
        if (num < 0) {
            throw new RuntimeException("Negative numbers are not allowed");
        }
        return num;
    }

    private static int add(int[] numbers) {
        int sum = 0;
        for (int num : numbers) {
            sum = sum + num;
        }
        return sum;
    }
}
