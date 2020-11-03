package calculator;

import java.util.function.BinaryOperator;

public enum FourPointOperation {
    NUMBER((x, y) -> y),
    PLUS((x, y) -> x + y),
    MINUS((x, y) -> x - y),
    TIMES((x, y) -> x * y),
    DIVIDE((x, y) -> x / y);

    private BinaryOperator<Integer> expression;

    FourPointOperation(BinaryOperator<Integer> expression) {
        this.expression = expression;
    }

    public Integer calculate(int a, int b) {
        return this.expression.apply(a, b);
    }
}
