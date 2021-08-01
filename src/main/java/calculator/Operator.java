package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (input1,input2) -> input1 + input2),
    SUBTRACT("-", (input1,input2) -> input1 - input2),
    MULTIPLY("*", (input1,input2) -> input1 * input2),
    DIVIDE("/", (input1,input2) -> {
        checkIfDivisorIsZero(input2);
        return input1 / input2;
    });

    private final String operator;
    private final BiFunction <Integer, Integer, Integer> biFunction;

    Operator(String operator, BiFunction<Integer, Integer, Integer> biFunction) {
        this.operator = operator;
        this.biFunction = biFunction;
    }

    public Integer calculate(int input1, int input2) {
        return this.biFunction.apply(input1, input2);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산자만 연산자로 쓸 수 있습니다."));
    }

    private static void checkIfDivisorIsZero(int input2) {
        if (input2 == 0) {
            throw new IllegalArgumentException("나눗셈의 제수는 0이 올 수 없습니다.");
        }
    }
}
