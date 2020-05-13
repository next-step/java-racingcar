package calculator.operator;

import calculator.exception.CannotBeDividedIntoZeroException;
import calculator.exception.NotSupportedOperationException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum FourArithmeticOperator {
    PLUS("+", Integer::sum),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new CannotBeDividedIntoZeroException();
        }

        return a / b;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> operation;

    FourArithmeticOperator(String operator, BiFunction<Integer, Integer, Integer> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public static int operate(int targetA, int targetB, String operator) {
        FourArithmeticOperator fourArithmeticOperator = Arrays.stream(FourArithmeticOperator.values())
                .filter(value -> value.operator.equals(operator))
                .findFirst()
                .orElseThrow(NotSupportedOperationException::new);

        return fourArithmeticOperator.operation.apply(targetA, targetB);
    }
}
