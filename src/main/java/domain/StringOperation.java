package domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum StringOperation {
    ADD("+", (first, second) -> first + second),
    SUBTRACT("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (second.equals(0)) {
            throw new RuntimeException("Can not divide by zero.");
        }
        return first / second;
    });

    private final String operatorSign;
    private final BiFunction<Integer, Integer, Integer> operation;

    private static final Map<String, StringOperation> STRING_OPERATIONS = Collections.unmodifiableMap(
            Stream.of(values())
            .collect(Collectors.toMap(StringOperation::getOperatorSign, Function.identity())));

    StringOperation(String operatorSign, BiFunction<Integer, Integer, Integer> operation) {
        this.operatorSign = operatorSign;
        this.operation = operation;
    }

    public static StringOperation of(String sign) {
        return Optional.ofNullable(STRING_OPERATIONS.get(sign))
                .orElseThrow(() -> new IllegalArgumentException("Expression contains unknown operation : " + sign));
    }

    public Integer operate(String firstNumber, String secondNumber) {
        return operate(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber));
    }

    public Integer operate(Integer firstNumber, Integer secondNumber) {
        return operation.apply(firstNumber, secondNumber);
    }

    private String getOperatorSign() {
        return operatorSign;
    }
}
