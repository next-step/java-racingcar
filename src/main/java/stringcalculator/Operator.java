package stringcalculator;

import java.util.function.BinaryOperator;

import static stringcalculator.Message.DIVIDE_ZERO;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        checkZero(y);
        return x / y;
    });
    private final String symbol;
    private final BinaryOperator<Integer> operator;

    Operator(String symbol, BinaryOperator<Integer> operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static void checkZero(int input) {
        if (input == 0) {
            throw new ArithmeticException(DIVIDE_ZERO);
        }
    }

    public int operate(int x, int y) {
        return operator.apply(x, y);
    }
}
