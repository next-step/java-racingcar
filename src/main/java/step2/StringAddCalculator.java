package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class StringAddCalculator {
    public static final String REGEX = ",|:";
    public static final int ZERO = 0;
    public static final String CUSTOM_REGEX = "//(.)\n(.*)";
    public static final int DELIMITER_GROUP = 1;
    public static final int TEXT_GROUP = 2;

    private static final Pattern CUSTOM_PATTERN = Pattern.compile(CUSTOM_REGEX);

    public static int splitAndSum(String text) {
        if (text == null || text.isEmpty()) {
            return ZERO;
        }

        return sum(toInts(split(text)));
    }

    public static int sum(List<Integer> numbers) {
        int result = ZERO;

        for (int number : numbers) {
            result += number;
        }

        return result;
    }

    public static List<Integer> toInts(String[] values) {
        List<Integer> numbers = new ArrayList<>();

        for (String value : values) {
            numbers.add(parseInt(value));
        }

        return numbers;
    }

    public static String[] split(String text) {
        String delimiter = detectDelimiter(text);
        String extractedText = extractText(text);

        return splitText(extractedText, delimiter);
    }

    private static String detectDelimiter(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);

        if (matcher.find()) {
            return matcher.group(DELIMITER_GROUP);
        }

        return REGEX;
    }

    private static String extractText(String text) {
        Matcher matcher = CUSTOM_PATTERN.matcher(text);

        if (matcher.find()) {
            return matcher.group(TEXT_GROUP);
        }

        return text;
    }

    private static String[] splitText(String text, String delimiter) {
        return text.split(delimiter);
    }
}
