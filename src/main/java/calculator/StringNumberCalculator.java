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
        return sum(toPositiveIntegers(split(input))).intValue();
    }

    private static PositiveInteger sum(PositiveInteger[] positiveIntegers) {
        PositiveInteger result = PositiveInteger.ZERO;
        for (PositiveInteger positiveInteger : positiveIntegers) {
            result = result.plus(positiveInteger);
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

    private static PositiveInteger[] toPositiveIntegers(String[] values) {
        PositiveInteger[] positiveIntegers = new PositiveInteger[values.length];
        for (int i = 0; i < values.length; i++) {
            positiveIntegers[i] = toPositiveInteger(values[i]);
        }
        return positiveIntegers;
    }

    private static PositiveInteger toPositiveInteger(String value) {
        return new PositiveInteger(value);
    }

    private static boolean isBlank(String input) {
        return input == null || input.isBlank();
    }

}
