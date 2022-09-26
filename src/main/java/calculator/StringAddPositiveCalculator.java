package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddPositiveCalculator {
    private static final String SEPARATOR = "[,:]";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static final int PATTERN_MATCHER_GROUP_CUSTOM_DELIMITER_INDEX = 1;
    private static final int PATTERN_MATCHER_GROUP_TEXT_ARRAY_INDEX = 2;
    private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_SEPARATOR);
    public static final Positive ZERO = new Positive(0);

    private StringAddPositiveCalculator() {
    }

    public static Positive splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return ZERO;
        }
        return sum(toPositives(splitString(text)));
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isBlank();
    }

    private static String[] splitString(String text) {
        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(PATTERN_MATCHER_GROUP_CUSTOM_DELIMITER_INDEX);
            return matcher.group(PATTERN_MATCHER_GROUP_TEXT_ARRAY_INDEX).split(customDelimiter);
        }
        return text.split(SEPARATOR);
    }

    private static List<Positive> toPositives(String[] splitTextArray) {
        return Arrays.stream(splitTextArray).map(Positive::new).collect(Collectors.toList());
    }

    private static Positive sum(List<Positive> numbers) {
        Positive result = ZERO;
        for (Positive number : numbers) {
            result = result.plus(number);
        }
        return result;
    }
}