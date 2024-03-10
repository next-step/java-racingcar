package util;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열 덧셈 계산기
 */
public class StringAddCalculator {
    private static final String DEFAULT_DELIMITER_REGEXP = ",|:";
    private static final String CUSTOM_DELIMITER_PATTERN_REGEXP = "//(.)\n(.*)";

    private static final int CUSTOM_SPLIT_DELIMITER_GROUP = 1;
    private static final int CUSTOM_SPLIT_TARGET_STRING_GROUP = 2;

    private static final Pattern customPattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN_REGEXP);

    private StringAddCalculator() {
    }

    /**
     * 문자열을 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.
     *
     * @param value 문자열
     * @return 분리한 숫자의 합. 단, null이나 빈 문자열의 경우 0을 반환한다.
     * @throws NumberFormatException 구분자에 의해 분리된 문자열 중 숫자가 아닌 값이 있는 경우
     * @throws IllegalArgumentException 구분자에 의해 분리된 문자열 중 음수가 있는 경우
     */
    public static int splitAndSum(String value) {
        if (isBlank(value)) {
            return 0;
        }

        final String[] splitValue = split(value);

        return mapToIntArrayAndSum(splitValue);
    }

    private static boolean isBlank(String value) {
        return value == null
                || value.isEmpty();
    }

    private static String[] split(String value) {
        final Matcher matcher = customDelimiterMatcher(value);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_SPLIT_DELIMITER_GROUP);
            return matcher.group(CUSTOM_SPLIT_TARGET_STRING_GROUP).split(customDelimiter);
        }
        return value.split(DEFAULT_DELIMITER_REGEXP);
    }

    private static Matcher customDelimiterMatcher(String value) {
        return customPattern.matcher(value);
    }

    private static int mapToIntArrayAndSum(String[] splitValue) {
        return Arrays.stream(splitValue)
                .mapToInt(StringAddCalculator::mapToInt)
                .sum();
    }

    private static int mapToInt(String value) {
        int intValue = Integer.parseInt(value);

        assertPositive(intValue);

        return intValue;
    }

    private static void assertPositive(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("문자열 덧셈 계산기는 음수를 지원하지 않습니다.");
        }
    }
}
