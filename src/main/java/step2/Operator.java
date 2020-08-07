package step2;

import java.util.Arrays;
import java.util.Optional;

public enum Operator {

    PLUS("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY_BY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDED_BY("/", (firstNumber, secondNumber) -> {
        if (secondNumber == 0) {
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
        Optional<Operator> operators = Arrays.stream(values()).filter(o -> o.operator.equals(value)).findFirst();
        return operators.orElseThrow(() -> new IllegalArgumentException(value + CommonConstant.INVALID_OPERATOR));
    }

    public int calculate(int firstNumber, int secondNumber) {
        return calculation.calculate(firstNumber, secondNumber);
    }

}
