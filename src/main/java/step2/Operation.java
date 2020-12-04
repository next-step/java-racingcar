package step2;

import java.util.Arrays;
import java.util.function.DoubleBinaryOperator;

public enum Operation {
    PLUS ("+", (x,y) -> x+y),
    MINUS ("-", (x,y) -> x-y),
    TIMES ("*", (x,y) -> x*y),
    DIVIDE ("/", (x,y) -> x/y);

    private final String operator;
    private final DoubleBinaryOperator binaryOperator;

    Operation(String operator, DoubleBinaryOperator binaryOperator) {
        this.operator = operator;
        this.binaryOperator = binaryOperator;
    }

    public static Operation getOperation(String operator) {
        return Arrays.stream(Operation.values())
                        .filter(operation -> operation.operator.equals(operator))
                        .findAny().orElseThrow(()-> new IllegalArgumentException());
    }

    public double calculate(double x, double y) {
        return binaryOperator.applyAsDouble(x, y);
    }
}
