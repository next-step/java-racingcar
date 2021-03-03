package step2;

import java.util.Arrays;

public enum CalculatorType {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    private final String calculatorType;
    private final Calculator calculator;

    CalculatorType(String calculatorType, Calculator calculator) {
        this.calculatorType = calculatorType;
        this.calculator = calculator;
    }

    public static CalculatorType findByCalculator(String type) {
        return Arrays.stream(CalculatorType.values())
                .filter(calType -> calType.getCalculatorType().equals(type))
                .findAny()
                //사칙연산 기호가 아닌 경우 IllegalArgumentException throw
                .orElseThrow(() -> new IllegalArgumentException("사칙연산이 아닙니다."));

    }

    public String getCalculatorType() {
        return this.calculatorType;
    }

    public int getCalculator(int leftNumber, int rightNumber) {
        return calculator.calculate(leftNumber, rightNumber);
    }

}
