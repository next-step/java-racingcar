package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static final String SEPARATOR = ",|:";
    public static final String CUSTOM_SEPARATOR_REGEX_PATTERN = "//(.)\n(.*)";

    public static int splitAndSum(String text) {
        if (isNullOrBlank(text)) {
            return 0;
        }

        Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR_REGEX_PATTERN).matcher(text);
        if (matcher.find()) {
            String customSeparator = matcher.group(1);
            String[] values = matcher.group(2).split(customSeparator);
            return toInts(values).stream()
                    .mapToInt(PositiveNumber::getNumber)
                    .sum();
        }

        String[] values = text.split(SEPARATOR);
        return toInts(values).stream()
                .mapToInt(PositiveNumber::getNumber)
                .sum();
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }

    private static List<PositiveNumber> toInts(String[] values) {
        return Arrays.asList(values).stream()
                .map(number-> new PositiveNumber(number))
                .collect(Collectors.toList());
    }

}
