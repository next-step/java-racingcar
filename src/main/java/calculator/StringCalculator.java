package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    public static final String DEFAULT_SEPARATORS = ",:";
    public static final String CUSTOM_SEPARATOR_REGEX = "//(.*)\\\\n";

    public static int splitAndSum(String input) {
        if (input == null || input.isBlank()) return 0;
        return sum(removeSeparatorPhrase(input).split(makeRegex(input)));
    }

    private static int sum(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            result += new Positive(number).number();
        }
        return result;
    }

    private static String removeSeparatorPhrase(String text) {
        return text.replaceAll(CUSTOM_SEPARATOR_REGEX, "");
    }

    private static String makeRegex(String text) {
        return "[" + DEFAULT_SEPARATORS + findCustomSeparators(text) + "]";
    }

    private static String findCustomSeparators(String text) {
        String customSeparators = "";
        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(text);
        while (matcher.find()) {
            String match = matcher.group(1);
            customSeparators += match;
        }
        return customSeparators;
    }
}
