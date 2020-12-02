package step2;

import java.util.function.DoubleBinaryOperator;

public enum Operation {
    PLUS ("+", (x,y) -> x+y),
    MINUS ("-", (x,y) -> x-y),
    TIMES ("*", (x,y) -> x*y),
    DIVIDE ("/", (x,y) -> x/y);

    private final String operator;
    private final DoubleBinaryOperator op;

    Operation(String operator, DoubleBinaryOperator op) {
        this.operator = operator;
        this.op = op;
    }

    public double calculate(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
