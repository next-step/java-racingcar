package calculator;

import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS(Integer::sum),
    MINUS((left, right) -> left - right),
    MULTIPLY((left, right) -> left * right),
    DIVIDE((left, right) -> left / right)

    ;

    private final IntBinaryOperator operator;

    Operator(IntBinaryOperator operator) {
        this.operator = operator;
    }

    public int apply(int left, int right) {
        return operator.applyAsInt(left, right);
    }
}
