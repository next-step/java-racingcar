package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if(b == 0){
            throw new IllegalArgumentException();
        }
        return a/b;
    }),
    NOTHING("", (a, b) -> null);

    private String operator;
    private BiFunction<Integer, Integer, Integer> calculator;

    static public Operation of(String operator) {
        return Arrays.stream(values()).filter(operation -> operation.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    Operation(String operator, BiFunction<Integer, Integer, Integer> calculator) {
        this.operator = operator;
        this.calculator = calculator;
    }

    public int calculate(int num1, int num2) {
        return calculator.apply(num1, num2);
    }
}
