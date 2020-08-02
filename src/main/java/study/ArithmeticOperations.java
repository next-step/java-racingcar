package study;

import java.util.function.BiFunction;

public enum ArithmeticOperations {
    ADDITION("+", (v1, v2) -> v1 + v2),
    SUBTRACTION("-", (v1, v2) -> v1 - v2),
    MULTIPLICATION("*", (v1, v2) -> v1 * v2),
    DIVISION("/", (v1, v2) -> {
        if (v2 == 0) {
            throw new IllegalArgumentException("Can not be divided by zero");
        }

        return v1 / v2;
    });

    private final String operation;
    private final BiFunction<Integer, Integer, Integer> calculate;

    ArithmeticOperations(String operation, BiFunction<Integer, Integer, Integer> calculate) {
        this.operation = operation;
        this.calculate = calculate;
    }

    public static ArithmeticOperations of(String operation) {
        for (ArithmeticOperations value : ArithmeticOperations.values()) {
            if (value.operation.equals(operation)) {
                return value;
            }
        }

        throw new IllegalArgumentException("Invalid operation. operation: " + operation);
    }

    public Integer calculate(int value1, int value2) {
        return calculate.apply(value1, value2);
    }
}
