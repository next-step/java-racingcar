package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {

    public static final String DEFAULT_DELIMITER = ",|:";
    public static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

    private StringAddCalculator() {

    }

    public static int splitAndSum(String text) {
        if (isBlank(text)) {
            return 0;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            String[] tokens = matcher.group(2).split(customDelimiter);
            return sum(toInts(tokens));
        }

        String[] values = split(text);
        return sum(toInts(values));
    }

    private static boolean isBlank(String text) {
        return text == null || text.isBlank();
    }

    private static String[] split(String text) {
        return text.split(DEFAULT_DELIMITER);
    }

    private static List<Positive> toInts(String[] values) {
        return Arrays.stream(values).map(Positive::new).collect(Collectors.toList());
    }

    private static int sum(List<Positive> positives) {
        return positives.stream().mapToInt(Positive::getNumber).sum();
    }
}
