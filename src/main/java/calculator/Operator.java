package calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {

    ADD("+", (firstNumber, secondNumber) -> firstNumber + secondNumber),
    SUB("-", (firstNumber, secondNumber) -> firstNumber - secondNumber),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber),
    DIVIDE("/", (firstNumber, secondNumber) -> firstNumber / secondNumber);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int result(String operator, int firstNumber, int secondNumber) {
        return findOperand(operator).expression.apply(firstNumber, secondNumber);
    }

    public static Operator findOperand(String operate) {
        return Arrays.stream(values())
            .filter(operation -> operation.operator.equals(operate))
            .findAny()
            .orElseThrow(
                () -> new IllegalArgumentException(CalculatorException.INVALID_ARITHMATIC));
    }
}
