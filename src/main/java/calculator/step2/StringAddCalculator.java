package calculator.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {

    private static final int ZERO = 0;
    private static final int CUSTOM_SEPARATOR = 1;
    private static final int INPUT_STRING = 2;
    private static final String NEGATIVE = "-";
    private static final String ONE_NUMBER_REGEX = "\\d+";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String text) {
        if (text == null || text.isBlank()) {
            return ZERO;
        }

        if (text.contains(NEGATIVE)) {
            throw new RuntimeException();
        }

        if (text.contains(",") || text.contains(":") || text.matches(ONE_NUMBER_REGEX)) {
            return sum(parse(text));
        }
        return sum(customParse(match(text)));
    }

    private static int sum(String[] numbers) {
        int number = 0;
        for (String s : numbers) {
            number += Integer.parseInt(s);
        }
        return number;
    }

    private static String[] parse(String text) {
        return text.split(",|:");
    }

    private static String[] customParse(Matcher matcher) {
        String[] tokens = null;
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_SEPARATOR);
            tokens = matcher.group(INPUT_STRING).split(customDelimiter);
        }
        return tokens;
    }

    private static Matcher match(String text) {
        return CUSTOM_PATTERN.matcher(text);
    }

}
