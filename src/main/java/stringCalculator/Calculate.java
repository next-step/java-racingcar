package stringCalculator;

import java.util.function.BiFunction;

public enum Calculate {

    ADD("+", (firstNumber, secondNumber) -> (firstNumber + secondNumber)),

    SUBTRACT("-", (firstNumber, secondNumber) -> (firstNumber - secondNumber)),

    MULTIPLE("*", (firstNumber, secondNumber) -> (firstNumber * secondNumber)),

    DIVISION("/", (firstNumber, secondNumber) -> (firstNumber / secondNumber));

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Calculate(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
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
