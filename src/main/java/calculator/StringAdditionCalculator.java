package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.quote;

public class StringAdditionCalculator {
    private static final String POSITIVE_NUMBER_REGEX = "[^0-9].*";
    private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

    public StringAdditionCalculator() {}

    public int splitAndSum(String str) throws Exception {
        if (str.isEmpty() || str == null) {
            return 0;
        }

        String[] tokens = parseStringToTokens(str);
        if (!allowedTokens(tokens)) {
            throw new Exception("include unexpected value");
        }

        return Arrays.stream(tokens).mapToInt(token -> Integer.parseInt(token)).sum();
    }

    private String[] parseStringToTokens(String str) {
        Matcher delimiterMatcher = CUSTOM_DELIMITER_PATTERN.matcher(str);
        if (delimiterMatcher.find()) {
            String customDelimiter = delimiterMatcher.group(1);
            customDelimiter = escapeIfDollarSign(customDelimiter);
            return delimiterMatcher.group(2).split(customDelimiter);
        }
        return str.split(",|:");
    }

    private boolean allowedTokens(String[] strings) {
        long notAllowedTokenCount = Arrays.stream(strings)
                .filter(str -> str.matches(POSITIVE_NUMBER_REGEX))
                .count();
        return notAllowedTokenCount == 0 ? true : false;
    }

    private String escapeIfDollarSign(String str) {
        if (str.equals("$")) {
            return quote(str);
        }
        return str;
    }
}
