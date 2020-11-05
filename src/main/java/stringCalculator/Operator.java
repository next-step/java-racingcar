package stringCalculator;

import java.util.function.BiFunction;

public enum Operator {

    ADD("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),

    SUBTRACT("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),

    MULTIPLE("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),

    DIVISION("/", (firstNumber, secondNumber) -> {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return firstNumber / secondNumber;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public Integer calculate(int firstNumber, int secondNumber) {
        return this.biFunction.apply(firstNumber, secondNumber);
    }

    public String getOperator() {
        return operator;
    }
}
