package step2;

import java.util.List;

import static step2.Input.getDefaultDelimiterRegex;

public class StringAddCalculator {

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
            return sumStringArray(input.splitWithDefaultRegex(getDefaultDelimiterRegex()));
        }

        return input.parseToInt();
    }

    private static int sumStringArray(List<String> tokens) {
        return tokens.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
