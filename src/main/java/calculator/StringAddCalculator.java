package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static final String DEFAULT_SEPARATOR = "[,|:]";
    private static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";
    private static Pattern CUSTOM_MATCHER = Pattern.compile(CUSTOM_SEPARATOR);
    private static final int DELIMITER_INDEX = 1;
    private static final int TOKEN_INDEX = 2;
    private static final String TOKEN_ILLEGAL = "-";
    private static final String MESSAGE_NEGATIVE_NUMBER = "음수는 올바른 숫자 입력값이 아닙니다";

    private StringAddCalculator() {
        throw new AssertionError();
    }

    public static int splitAndSum(String text) {
        // 1. 인자 유효성 검증
        if (isNullOrBlank(text)) {
            return 0;
        }

        validateNegativeNumberAndThrow(text);

        if (isSingleNumeric(text)) {
            return Integer.parseInt(text);
        }

        // 2. 인자 분리
        List<String> splitTextList = splitBySeparator(text);

        // 3. 분리된 인자 총합 계산
        return totalSum(splitTextList);
    }

    private static int totalSum(List<String> splitTextList) {
        return splitTextList.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private static List<String> splitBySeparator(String text) {
        List<String> splitTextList;
        Matcher customMatcher = CUSTOM_MATCHER.matcher(text);

        if (customMatcher.find()) {
            splitTextList = Arrays.asList(customMatcher.group(TOKEN_INDEX)
                    .split(customMatcher.group(DELIMITER_INDEX)));
            return splitTextList;
        }

        splitTextList =  Arrays.asList(text.split(DEFAULT_SEPARATOR));

        return splitTextList;
    }

    private static void validateNegativeNumberAndThrow(String text) throws IllegalArgumentException {
        if (text.contains(TOKEN_ILLEGAL)) {
            throw new IllegalArgumentException(MESSAGE_NEGATIVE_NUMBER);
        }
    }

    private static boolean isSingleNumeric(String text) {
        return text.matches("\\d+");
    }

    private static boolean isNullOrBlank(String text) {
        return text == null || text.isEmpty();
    }
}