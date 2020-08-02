package study;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    private static final Map<String, ArithmeticOperations> operations = Collections.unmodifiableMap(Stream.of(values())
            .collect(Collectors.toMap(ArithmeticOperations::getOperation, Function.identity())));

    public static ArithmeticOperations of(String operation) {
        return Optional.ofNullable(operations.get(operation))
                .orElseThrow(() -> new IllegalArgumentException("Invalid operation. operation: " + operation));
    }

    public Integer calculate(int value1, int value2) {
        return calculate.apply(value1, value2);
    }

    public String getOperation() {
        return operation;
    }
}
