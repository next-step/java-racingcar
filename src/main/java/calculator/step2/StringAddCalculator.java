package calculator.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringAddCalculator {

    private static final int ZERO = 0;
    private static final int CUSTOM_SEPARATOR = 1;
    private static final int INPUT_STRING = 2;
//    private static final String NEGATIVE = "-";
    private static final String ONE_NUMBER_REGEX = "\\d+";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int calculate(String text) {
        if (text == null || text.isBlank()) {
            return ZERO;
        }

        if (hasContainNegative(text)) {
            throw new IllegalArgumentException(String
                    .format("text(%s)엔 음수가 포함되어 있습니다. 음수는 허용되지 않습니다.", text));
        }

        if (text.contains(",") || text.contains(":") || text.matches(ONE_NUMBER_REGEX)) {
            return sum(parse(text));
        }
        return sum(customParse(match(text)));
    }

    private static boolean hasContainNegative(String text) {
        String[] stringNumbers = parse(text);
        for (String stringNumber : stringNumbers) {
            int number = Integer.parseInt(stringNumber);
            if (number < 0) {
                return true;
            }
        }
        return false;
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
