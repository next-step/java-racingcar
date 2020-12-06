package calculator;

import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS(Integer::sum);

    private final IntBinaryOperator operator;

    Operator(IntBinaryOperator operator) {
        this.operator = operator;
    }

    public int apply(int left, int right) {
        return operator.applyAsInt(left, right);
    }
}
