package step2;

import java.util.List;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

    /**
     * 문자열 덧셈 계산기
     * @param input 입력값
     * @return 계산 결과
     */
    public static int splitAndSum(Input input) {
        if (input.isNotValidInput()) {
            return 0;
        }

        if (input.hasCustomDelimiter()) {
            return sumStringArray(input.parseWithCustomDelimiterOrNull());
        }

        if (input.hasDefaultDelimiter()) {
            return sumStringArray(input.splitWithDefaultRegex(DEFAULT_DELIMITER_REGEX));
        }

        return input.parseToInt();
    }

    /**
     * StringArray 의 sum 값을 반환하는 함수
     */
    private static int sumStringArray(List<String> tokens) {
        return tokens.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

}
