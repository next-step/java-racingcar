package calculator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLE("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    private final String name;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String name, BiFunction<Integer, Integer, Integer> biFunction) {
        this.name = name;
        this.biFunction = biFunction;
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(v -> v.name.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자를 확인해주세요."));
    }

    public int calculate(int a, int b) {
        return this.biFunction.apply(a, b);
    }
}
