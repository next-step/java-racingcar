package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringNumberCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String input) {
        if (isBlank(input)) {
            return 0;
        }
        return sum(toPositiveIntegers(parseInts(split(input)))).intValue();
    }

    private static PositiveNumber sum(PositiveNumber[] positiveNumbers) {
        PositiveNumber result = PositiveNumber.ZERO;
        for (PositiveNumber positiveNumber : positiveNumbers) {
            result = result.plus(positiveNumber);
        }
        return result;
    }

    private static String[] split(String input, String delimiter) {
        return input.split(delimiter);
    }

    private static String[] split(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (!matcher.find()) {
            return split(input, DEFAULT_DELIMITER);
        }
        return split(matcher.group(2), matcher.group(1));
    }

    private static int[] parseInts(String[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = parseInt(values[i]);
        }
        return result;
    }

    private static int parseInt(String value) {
        if (isBlank(value)) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

    private static PositiveNumber[] toPositiveIntegers(int[] values) {
        PositiveNumber[] positiveNumbers = new PositiveNumber[values.length];
        for (int i = 0; i < values.length; i++) {
            positiveNumbers[i] = new PositiveNumber(values[i]);
        }
        return positiveNumbers;
    }

}
