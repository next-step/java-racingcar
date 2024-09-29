package study.step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_DELIMITER_PREFIX = "//(.)\n(.*)";
    private static final int GROUP_INDEX_ONE = 1;
    private static final int GROUP_INDEX_TWO = 2;

    public static int splitAndSum(String input) {
        if (!hasText(input)) {
            return 0;
        }
        String[] splitValues = split(input);
        return sum(splitValues);
    }

    private static boolean hasText(String input) {
        return input != null && !input.isEmpty();
    }

    private static String[] split(String input) {
        Matcher m = Pattern.compile(CUSTOM_DELIMITER_PREFIX).matcher(input);
        if (m.find()) {
            String customDelimiter = m.group(GROUP_INDEX_ONE);
            return m.group(GROUP_INDEX_TWO).split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITER);
    }

    private static int sum(String[] values) {
        return Arrays.stream(values)
                .mapToInt(StringAddCalculator::parseIntOrThrow)
                .sum();
    }

    private static int parseIntOrThrow(String value) {
        int number = Integer.parseInt(value);
        if (number < 0) {
            throw new RuntimeException("음수는 입력할 수 없습니다.");
        }
        return number;
    }

}
