package step2;

import step2.util.StringParser;

import java.util.Arrays;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    /**
     * 문자열 덧셈 계산기
     * @param input 입력값
     * @return 계산 결과
     */
    public static int splitAndSum(String input) {
        if (!isValidInput(input)) {
            return 0;
        }

        if (StringParser.hasCustomDelimiter(input)) {
            return sumStringArray(StringParser.parseWithCustomDelimiterOrNull(input));
        }

        if (hasDefaultDelimiter(input)) {
            return sumStringArray(input.split(DEFAULT_DELIMITER_REGEX));
        }

        return Integer.parseInt(input.strip());
    }

    /**
     * 유효한 입력 값인지 판단하는 함수
     */
    private static boolean isValidInput(String input) {
        if (input == null || input.isBlank()) {
            return false;
        }
        StringParser.hasNegativeNumber(input);
        return true;
    }

    /**
     * StringArray 의 sum 값을 반환하는 함수
     */
    private static int sumStringArray(String[] tokens) {
        return Arrays.stream(tokens)
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    }

    /**
     * 기본 구분자를 사용하는지 판단 하는 함수
     */
    private static Boolean hasDefaultDelimiter(String input) {
        return input.contains(",") || input.contains(":");
    }
}
