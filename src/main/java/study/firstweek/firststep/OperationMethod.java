package study.firstweek.firststep;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperationMethod {
    ADD("+", (a, b) -> a + b),
    SUBTRACT("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String method;
    private BiFunction<Integer, Integer, Integer> operator;

    OperationMethod(String method,
        BiFunction<Integer, Integer, Integer> operator) {
        this.method = method;
        this.operator = operator;
    }

    public static OperationMethod of(String method) {
        return Arrays.stream(values())
            .filter(operationMethod -> operationMethod.method.equals(method))
            .findFirst()
            .orElseThrow(() ->
                new IllegalArgumentException("We only accept the methods in ( + , -,  * , / )"));
    }

    public int calculate(int a, int b) {
        return operator.apply(a, b);
    }
}
