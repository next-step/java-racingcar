package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAndCalculator {
    private static final String EXTENSION_MATCH_PATTERN = "//(.)\n(.*)";
    private static final String NORMAL_MATCH_PATTERN = "[,:]";
    private static final int MATCHER_FIRST_GROUP = 1;
    private static final int MATCHER_SECOND_GROUP = 2;
    private static final int ZERO_VALUE = 0;

    public static int splitAndSum(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            return ZERO_VALUE;
        }

        return sumIntegers(stringsToIntegers(textToStrings(text)));
    }

    private static String[] textToStrings(String text) {
        Matcher matcher = Pattern.compile(EXTENSION_MATCH_PATTERN).matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(MATCHER_FIRST_GROUP);
            return matcher.group(MATCHER_SECOND_GROUP).split(customDelimiter);
        }

        return text.split(NORMAL_MATCH_PATTERN);
    }

    private static List<Integer> stringsToIntegers(String[] values) {
        return Arrays.stream(values)
                .map(StringAndCalculator::stringToInt)
                .collect(Collectors.toList());
    }

    private static int stringToInt(String value) {
        int intValue = Integer.parseInt(value);
        if (intValue < 0) {
            throw new RuntimeException();
        }
        return intValue;
    }

    private static int sumIntegers(List<Integer> integers) {
        return integers.stream()
                .mapToInt(item -> item)
                .sum();
    }
}
