package calculator;

import calculator.exception.IllegalStringAddFormatException;
import calculator.exception.NegativeNumberException;

public class StringAddCalculator {
    private StringAddCalculator() {
    }

    /**
     * <code>,</code> 또는 <code>;</code>로 구분된 모든 양수 정수의 합을 구합니다.
     * <p>
     * 사용자 정의 구분자를 지정하려면 입력 문자열의 시작 부분에 존재하는 <code>//</code>와 <code>\n</code> 사이에 문자를 지정하면 해당 문자를
     * 구분자로 사용합니다. 사용자 정의 구분자가 존재하면, 기본 구분자인 <code>,</code>와 <code>;</code>는 무시됩니다.
     * <p>
     * 예시는 다음과 같습니다.
     * <pre>
     *    int five = calculator.StringAddCalculator.sum("1,3;1")
     *    int six = calculator.StringAddCalculator.sum("//_\n1_2_3")
     * </pre>
     *
     * @param text 계산할 문자열
     * @return 양수 정수의 합
     * @throws IllegalStringAddFormatException 문자열의 형식이 올바르지 않거나 음수 값이 있을 경우 예외 발생
     */
    public static int sum(String text) {
        if (isNullOrEmpty(text)) {
            return 0;
        }

        DelimitedText delimitedText = DelimitedText.from(text);

        return delimitedText
                .split()
                .stream()
                .mapToInt(StringAddCalculator::parseInt)
                .peek(StringAddCalculator::checkNegativeInt)
                .sum();
    }

    private static boolean isNullOrEmpty(String text) {
        return text == null || text.isEmpty();
    }

    private static int parseInt(String string) {
        try {
            int num = Integer.parseInt(string);
            return num;

        } catch (NumberFormatException e) {
            throw new IllegalStringAddFormatException("input can't be parsed as integer value. " + e.getMessage());
        }
    }

    private static void checkNegativeInt(int num) {
        if (num < 0) {
            throw new NegativeNumberException("input must be non negative value: " + num);
        }
    }
}
