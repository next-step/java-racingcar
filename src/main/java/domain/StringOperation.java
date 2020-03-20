package domain;

import java.util.Arrays;
import java.util.function.BiFunction;

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

    StringOperation(String operatorSign, BiFunction<Integer, Integer, Integer> operation) {
        this.operatorSign = operatorSign;
        this.operation = operation;
    }

    public static StringOperation of(String sign) {
        return Arrays.stream(values())
                .filter(stringOperation -> sign.equals(stringOperation.operatorSign))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Expression contains unknown operation."));
    }

    public Integer operate(String firstNumber, String secondNumber) {
        return operate(Integer.parseInt(firstNumber), Integer.parseInt(secondNumber));
    }

    public Integer operate(Integer firstNumber, Integer secondNumber) {
        return operation.apply(firstNumber, secondNumber);
    }
}
