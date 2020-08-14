package step2;

import java.util.Arrays;

public enum Operator {

    PLUS("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY_BY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDED_BY("/", (firstNumber, secondNumber) -> {
        if (secondNumber == CommonConstant.ZERO_NUMBER) {
            throw new IllegalArgumentException(CommonConstant.INVALID_DIVIDED_BY_ZERO);
        }
        return firstNumber / secondNumber;
    });

    private String operator;
    private Calculation calculation;

    Operator(String operator, Calculation calculation) {
        this.operator = operator;
        this.calculation = calculation;
    }

    public static Operator of(String value) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(value + CommonConstant.INVALID_OPERATOR));
    }

    public int calculate(int firstNumber, int secondNumber) {
        return calculation.calculate(firstNumber, secondNumber);
    }

}
