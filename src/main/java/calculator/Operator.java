package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operator {
    ADD("+", Integer::sum),
    SUB("-", (left, right) -> left - right),
    MUL("*", (left, right) -> left * right),
    DIV("/", (left, right) -> left / right);

    private String description;
    private IntBinaryOperator operator;

    Operator(String description, IntBinaryOperator operator) {
        this.description = description;
        this.operator = operator;
    }

    public static Operator valueOfString(String str) {
        return Arrays.stream(Operator.values())
                .filter(i -> str.equals(i.description))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int execute(int a, int b) {
        return operator.applyAsInt(a, b);
    }
}
