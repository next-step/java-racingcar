package study;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DELIMITER = ",|:";

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        String[] tokens = split(text);

        return sum(tokens);
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(e -> parsePositiveInt(e))
                .sum();
    }

    private static int parsePositiveInt(String token) {
        int number;

        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }

        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        return number;
    }

    private static String[] split(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
        String delimiter = DELIMITER;

        if (matcher.find()) {
            String customDelimiter = matcher.group(1);
            delimiter += "|" + customDelimiter;
            text = matcher.group(2);
        }

        return text.split(delimiter);
    }

    private static boolean isNullOrEmpty(String text) {
        return Objects.isNull(text) || text.isEmpty();
    }
}
