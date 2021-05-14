package calculator;

import java.util.function.ToIntBiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0) {
            throw new IllegalArgumentException(CalculConstant.CAN_NOT_DIVIDE_ZERO);
        }
        return num1 / num2;
    });


    private String symbol;
    private ToIntBiFunction<Integer, Integer> operation;

    Operator(String symbol, ToIntBiFunction<Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int operate(int num1, int num2) {
        return operation.applyAsInt(num1, num2);
    }

}
