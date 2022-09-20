package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT_VALUE = 0;
    private static final Pattern pattern = Pattern.compile(("//(.)\n(.*)"));
    private static final String FIRST_DEFAULT_DELIMITER = ":";
    private static final String SECOND_DEFAULT_DELIMITER = ",";
    private static final String OR = "|";

    public static int splitAndSum(String input) throws IllegalArgumentException {
        if (isInvalid(input)) {
            return DEFAULT_VALUE;
        }
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return getSum(matcher.group(2).split(customDelimiter));
        }
        return getSum(input.split(FIRST_DEFAULT_DELIMITER + OR + SECOND_DEFAULT_DELIMITER));
    }

    private static boolean isInvalid(String input) {
        return input == null || input.isEmpty();
    }

    private static Integer getSum(String[] input) {
        return Arrays.stream(input).map(StringAddCalculator::mapToInt).reduce(Integer::sum).orElse(DEFAULT_VALUE);
    }

    private static Integer mapToInt(String input) {
        try {
            return throwExpIfMinus(Integer.parseInt(input));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("input must be number", e);
        }
    }

    private static int throwExpIfMinus(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("input number must be positive");
        }
        return num;
    }
}
