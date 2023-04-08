package study;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";
    private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

    public static int splitAndSum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        return sum(split(text));
    }

    private static int sum(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(StringAddCalculator::parsePositiveInt)
                .sum();
    }

    private static int parsePositiveInt(String token) {
        int number = parseInt(token);

        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }

        return number;
    }

    private static int parseInt(String token) {
        int number;

        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new RuntimeException("숫자 포멧을 확인해 주세요.");
        }

        return number;
    }

    private static String[] split(String text) {
        Matcher matcher = CUSTOM_DELIMITER.matcher(text);
        String delimiter = DEFAULT_DELIMITER;

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
