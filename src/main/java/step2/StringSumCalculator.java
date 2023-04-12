package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    private static final String COMMA_SEMICOLON_REGEX = "[,;]";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final int ZERO = 0;
    private static final String NEGATIVE = "-";

    public static int splitAndSum(String input) {
        if (isNullOrBlank(input)) return ZERO;

        validatePositive(input);

        return sum(parseInts(splitNumber(input)));
    }

    private static boolean isNullOrBlank(String input) {
        return input == null || input.isBlank();
    }

    private static void validatePositive(String input) {
        if (input.contains(NEGATIVE)) {
            throw new RuntimeException("input has negative number");
        }
    }

    private static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private static int[] parseInts(String[] stringNumbers) {
        return Arrays.stream(stringNumbers)
                .mapToInt(StringSumCalculator::parseInt)
                .toArray();
    }

    private static int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return ZERO;
        }
    }


    private static String[] splitNumber(String input) {
        Matcher matcher = CUSTOM_PATTERN.matcher(input);
        if (matcher.find()) {
            String text = matcher.group(2);
            String separator = matcher.group(1);
            return text.split(separator);
        }
        return input.split(COMMA_SEMICOLON_REGEX);
    }

}
