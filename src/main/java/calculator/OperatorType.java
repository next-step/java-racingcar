package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum OperatorType {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String symbol;
    private BinaryOperator<Integer> operation;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    OperatorType(String symbol, BinaryOperator<Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public String getSymbol() {
        return symbol;
    }

    public int operation(int a, int b) {
        return operation.apply(a, b);
    }

    public static OperatorType findOper(String symbol) {
        return Arrays.stream(OperatorType.values())
                .filter(oper -> oper.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(CalculatorErrorMessage.ARITHMETIC_SYMBOLS_ERROR));
    }

}
