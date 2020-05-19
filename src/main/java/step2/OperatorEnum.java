package step2;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum OperatorEnum {

    ADD("+", (a, b) -> a + b),
    SUB("-", (a, b) -> a - b),
    MUL("*", (a, b) -> a * b),
    DIV("/", (a, b) -> a / b);

    private String operator;
    private BinaryOperator<Integer> expression;

    OperatorEnum(String operator, BinaryOperator<Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public int calc(int a, int b) {
        return expression.apply(a, b);
    }

    static OperatorEnum of(String operator) {
        return Arrays.stream(values())
                .filter(v -> operator.equals(v.operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("처리 불가능한 사칙연산 기호가 포함되어있습니다."));
    }
}
