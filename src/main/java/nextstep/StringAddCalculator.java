package nextstep;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String CUSTOM_SEPARATOR_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile(CUSTOM_SEPARATOR_REGEX);
    private static final String DEFAULT_SEPARATORS_REGEX = "[,:]";

    private static final int DELIMITER_INDEX = 1;
    private static final int TOKENS_INDEX = 2;

    private static final int BASE_VALUE = 0;


    static int splitAndSum(String text) {
        if (!isValidText(text)) {
            return 0;
        }

        final Pair<String, String> parsed = convertTextToParsed(text);
        final String[] tokens = convertParsedToTokens(parsed);
        final int[] integers = convertTokensToIntegers(tokens);

        return sum(integers);
    }

    private static boolean isValidText(String text) {
        return !isEmptyText(text);
    }

    private static boolean isEmptyText(String text) {
        return text == null || text.isEmpty();
    }

    private static Pair<String, String> convertTextToParsed(String text) {
        final Matcher m = CUSTOM_SEPARATOR_PATTERN.matcher(text);

        if (m.find()) {
            return new Pair<>(m.group(DELIMITER_INDEX), m.group(TOKENS_INDEX));
        }

        return new Pair<>(DEFAULT_SEPARATORS_REGEX, text);
    }

    private static String[] convertParsedToTokens(Pair<String, String> parsed) {
        final String delimiters = parsed.getFirst();
        final String body = parsed.getSecond();

        return body.split(delimiters);
    }

    private static int[] convertTokensToIntegers(String[] tokens) {
        final int[] integers = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            integers[i] = tokenToPositiveInteger(tokens[i]);
        }

        return integers;
    }

    private static int tokenToPositiveInteger(String token) {
        int integer = tokenToInteger(token);
        validateInteger(integer);
        return Integer.parseInt(token);
    }

    private static int tokenToInteger(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("Token is not a valid integer value: %s", token));
        }
    }

    private static void validateInteger(int integer) {
        if (integer < 0) {
            throw new IllegalArgumentException(String.format("Negative integer values are not allowed: %s", integer));
        }
    }

    private static int sum(int[] integers) {
        int sum = BASE_VALUE;

        for (final int i : integers) {
            sum += i;
        }

        return sum;
    }
}
