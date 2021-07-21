package study.calculator;

import sun.invoke.empty.Empty;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public enum Operation {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVISION("/", (a, b) -> a / b),
    EMPTY("", null);

    private final String operation;
    private final BiFunction<Integer, Integer, Integer> operationFunction;

    Operation(String operation, BiFunction<Integer, Integer, Integer> operationFunction) {
        this.operation = operation;
        this.operationFunction = operationFunction;
    }

    public int calculateNumbers(int num1, int num2){
        return this.operationFunction.apply(num1, num2);
    }

    public static Operation chooseOperation(String operation){
        return Arrays.stream(Operation.values())
                .filter(v -> v.getOperation().equals(operation))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("일치하는 연산자가 없습니다."));
    }

    public String getOperation() {
        return operation;
    }
}
