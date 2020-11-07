package calculator;

import java.util.function.BinaryOperator;

public enum FourPointOperation {


    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private String operator;
    private BinaryOperator<Integer> expression;

    FourPointOperation(String operator, BinaryOperator<Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static FourPointOperation value(String operator) {
        for (FourPointOperation value : values()) {
            if (value.operator.equals(operator)) {
                return value;
            }
        }

        throw new NullPointerException("operator is null");
    }


    public Integer calculate(int a, int b) {
        return this.expression.apply(a, b);
    }
}
