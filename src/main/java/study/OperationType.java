package study;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperationType {
    ADD("+", (operand1, operand2) -> (operand1 + operand2)),
    SUBTRACT("-", (operand1,operand2) -> (operand1 - operand2)),
    MULTIPLE("*", (operand1, operand2) -> (operand1 * operand2)),
    DIVIDE("/", (operand1, operand2) -> (operand1 / operand2));

    private final String sign;
    private final BiFunction<Integer, Integer, Integer> expression;

    OperationType(String sign, BiFunction<Integer, Integer, Integer> expression) {
        this.sign = sign;
        this.expression = expression;
    }

    public static OperationType findByOperator(String operator) {
        return Arrays.stream(OperationType.values())
                .filter(v -> operator.equals(v.sign))
                .findFirst().orElseThrow(() -> new IllegalArgumentException(String.format("%s는 사칙연산에 해당하지 않는 표현식입니다.", operator)));
    }

    public int operate(int operand1, int operand2) {
        return expression.apply(operand1, operand2);
    }
}
