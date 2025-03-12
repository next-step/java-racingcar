package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final Pattern DEFAULT_DELIMITERS_PATTERN = Pattern.compile("[,:]");
    private static final Pattern CUSTOM_DELIMITER_PARSE_PATTERN = Pattern.compile("//(.)\n(.*)");
    public static final String VALID_INTEGER_PATTERN = "-?\\d+";

    public static int splitAndSum(String text) {

        if (text == null ||  text.isEmpty()) {
            return 0;
        }

        String[] tokens = splitIntoTokens(text);
        return sumPositiveNumbersOrThrow(tokens);
    }

    private static int sumPositiveNumbersOrThrow(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (!isValidInteger(token)) {
                throw new RuntimeException("Invalid input: " + token);
            }

            int num = Integer.parseInt(token);
            if (num < 0) {
                throw new RuntimeException("Negative numbers not allowed: " + token);
            }

            sum += num;
        }
        return sum;
    }

    private static String[] splitIntoTokens(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PARSE_PATTERN.matcher(text);

        if (matcher.find()) {
            String customDelimiter = Pattern.quote(matcher.group(1));
            return matcher.group(2).split(customDelimiter);
        }

        return DEFAULT_DELIMITERS_PATTERN.split(text);
    }

    private static boolean isValidInteger(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return input.matches(VALID_INTEGER_PATTERN);
    }
}
