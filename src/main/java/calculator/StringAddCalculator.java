package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final int DELIMITER_GROUP_INDEX = 1;
    private static final int TOKEN_GROUP_INDEX = 2;

    public static int splitAndSum(String input) {
        String[] tokens = split(input);
        validatePositive(tokens);
        return sum(tokens);
    }

    private static String[] split(String input) {
        if (input == null || input.isBlank()) {
            return new String[0];
        }

        if (hasCustomDelimiter(input)) {
            return splitByCustomDelimiter(input);
        }

        return splitByDefaultDelimiter(input);
    }

    private static void validatePositive(String[] tokens) {
        for (String token : tokens) {
            if (!token.matches("\\d+")) {
                throw new RuntimeException("Invalid token: " + token);
            }
        }
    }

    private static int sum(String[] inputs) {
        return Arrays.stream(inputs)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean hasCustomDelimiter(String input) {
        return CUSTOM_DELIMITER_PATTERN.matcher(input).matches();
    }

    private static String[] splitByCustomDelimiter(String input) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(DELIMITER_GROUP_INDEX);
            return matcher.group(TOKEN_GROUP_INDEX).split(delimiter);
        }

        throw new RuntimeException("Invalid custom delimiter input format.\n input : " + input);
    }

    private static String[] splitByDefaultDelimiter(String input) {
        return input.split(DEFAULT_DELIMITER);
    }

}
