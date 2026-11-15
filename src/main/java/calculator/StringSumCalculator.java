package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSumCalculator {
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(.*?)\n(.*)", Pattern.DOTALL);
    private static final String DEFAULT_SEPARATOR = ",|:";

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int result = 0;
        final String[] tokens = separate(input);

        for (String s : tokens) {
            NonNegativeNumber number = new NonNegativeNumber(s);
            result += number.getValue();
        }
        return result;
    }

    private static String[] separate(String input) {
        String target = input;

        String separator = DEFAULT_SEPARATOR;
        Matcher m = CUSTOM_SEPARATOR_PATTERN.matcher(target);
        if (m.matches()) {
            validateCustomSeparator(m.group(1));
            separator = separator + "|" + Pattern.quote(m.group(1));
            target = m.group(2);
        }

        return target.split(separator);
    }

    private static void validateCustomSeparator(String customSeparator) {
        if (customSeparator.isEmpty()) {
            throw new RuntimeException("custom separator is empty.");
        }
        if (customSeparator.length() > 1) {
            throw new RuntimeException("custom separator must be a single character.");
        }
        if (Character.isDigit(customSeparator.charAt(0))) {
            throw new RuntimeException("custom separator can not be a number.");
        }
        if (customSeparator.equals("-")) {
            throw new RuntimeException("custom separator can not be '-'.");
        }
    }
}
