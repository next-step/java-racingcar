package stringcalculator;

import java.util.Objects;

/**
 * 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
 * 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
 * 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
 */
public class StringCalculator {
    private static final String DELIMITER = " ";
    private static final int INT_ZERO = 0;

    private String input;

    public StringCalculator(String input) {
        validateInput(input);

        this.input = input;
    }

    private void validateInput(String input) {
        if (Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 Null 이거나 비어있습니다.");
        }
    }

    public double calculate() {
        String[] inputDatas = input.split(DELIMITER);

        double sum = Double.parseDouble(inputDatas[INT_ZERO]);

        for (int index = 1; index < inputDatas.length; index += 2) {
            CalculatorNumber calculatorNumber = new CalculatorNumber(inputDatas, index, sum);
            sum = calculatorNumber.calculate();
        }

        return sum;
    }
}
