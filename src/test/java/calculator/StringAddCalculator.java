package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final int DEFAULT_RESULT_VALUE = 0;
    private static final String DEFAULT_DELIMITER = ":|,";
    private static final Pattern pattern = Pattern.compile(("//(.)\n(.*)"));

    public static int splitAndSum(String input) throws IllegalArgumentException {
        if (isInvalid(input)) {
            return DEFAULT_RESULT_VALUE;
        }
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            return getSum(matcher.group(2).split(customDelimiter));
        }
        return getSum(input.split(DEFAULT_DELIMITER));
    }

    private static boolean isInvalid(String input) {
        return input == null || input.isEmpty();
    }

    private static Integer getSum(String[] input) {
        return Arrays.stream(input).map(StringIntParser::mapToInt).reduce(Integer::sum).orElse(DEFAULT_RESULT_VALUE);
    }


}
