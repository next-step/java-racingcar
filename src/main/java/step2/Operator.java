package step2;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (n1, n2) -> n1 + n2),
    MINUS("-", (n1, n2) -> n1 - n2),
    MULTIPLY("*", (n1, n2) -> n1 * n2),
    DIVIDE("/", (n1, n2) -> n1 / n2);

    private String sign;
    private BinaryOperator<Integer> operation;

    Operator(String sign, BinaryOperator<Integer> operation) {
        this.sign = sign;
        this.operation = operation;
    }
}
