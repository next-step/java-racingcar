package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final Pattern CUSTOM_DELIMITERS_PATTERN = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {

        if (isNullOrBlank(text)) return 0;

        if (text.contains("-")) throw new RuntimeException("input has negative");

        String[] tokens;
        Matcher m = CUSTOM_DELIMITERS_PATTERN.matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
        } else
            tokens = text.split("[,:]");

        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isBlank();
    }
}
