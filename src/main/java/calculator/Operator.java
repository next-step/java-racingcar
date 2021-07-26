package calculator;

import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MUlTI("*", (x, y) -> x * y),
    DIVIDE("/", (x , y) -> x / y);

    private final String operator;
    private final BinaryOperator<Integer> value;

    Operator(String operator, BinaryOperator<Integer> value) {
        this.operator = operator;
        this.value = value;
    }

    public String getOperator() {
        return operator;
    }

    public BinaryOperator<Integer> getValue() {
        return value;
    }

    public int operate(int x, int y) {
        return value.apply(x, y);
    }

    public static Operator operatorOf(String operator) {
        if (PLUS.operator.equals(operator)) {
            return PLUS;
        }
        if (MINUS.operator.equals(operator)) {
            return MINUS;
        }
        if (MUlTI.operator.equals(operator)) {
            return MUlTI;
        }
        if (DIVIDE.operator.equals(operator)) {
            return DIVIDE;
        }
        throw new IllegalArgumentException();
    }
}
