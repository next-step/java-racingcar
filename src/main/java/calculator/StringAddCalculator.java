package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = ",|:";
    private static final int REGEX_DELIMITER_GROUP = 1;
    private static final int REGEX_NUMBER_GROUP = 2;
    public static int splitAndSum(String text) {

        if (isNullOfEmpty(text)) {
            return 0;
        }

        String[] tokens = splitTokens(text);

        if (hasNegativeNumber(tokens)) {
            throw new RuntimeException();
        }

        Integer result = 0;

        for (String token : tokens) {
            result += Integer.parseInt(token);
        }
        return result;
    }

    public static boolean isNullOfEmpty(String input) {
        if (input == null) {
            return true;
        }
        if (input.isEmpty()) {
            return true;
        }
        return false;
    }
    public static String[] splitTokens(String input) {
        Matcher m = CUSTOM_PATTERN.matcher(input);

        if (m.find()) {
            String customDelimiter = m.group(REGEX_DELIMITER_GROUP);
            String[] tokens = m.group(REGEX_NUMBER_GROUP).split(customDelimiter);

            return tokens;
        }

        return input.split(DEFAULT_DELIMITER);
    }

    public static boolean hasNegativeNumber(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .anyMatch(number -> number < 0);
    }
}
