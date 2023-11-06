package step2.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static int[] parse(final String input) {
        if (isEmpty(input)) {
            return new int[0];
        }

        return toInts(split(input));
    }

    private static boolean isEmpty(final String input) {
        return input == null || input.isEmpty();
    }

    private static String[] split(final String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);

        if (matcher.find()) {
            final String customDelimiter = matcher.group(1);
            final String numbers = matcher.group(2);

            return numbers.split("\\" + customDelimiter);
        }

        return input.split("[,|:]");
    }

    private static int[] toInts(final String[] numbers) {
        int[] intNumbers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            final int parseInt = Integer.parseInt(numbers[i]);

            if (parseInt < 0) {
                throw new RuntimeException("Input must be a positive integer");
            }

            intNumbers[i] = parseInt;
        }

        return intNumbers;
    }
}
