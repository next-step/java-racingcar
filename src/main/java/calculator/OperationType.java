package calculator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.IntBinaryOperator;

public enum OperationType {

    ADD("+", (value1, value2) -> value1 + value2 ),
    SUBTRACT("-", (value1, value2) -> value1 - value2 ),
    MULTIPLY("*", (value1, value2) -> value1 * value2 ),
    DIVISION("/", (value1, value2) -> value1 / value2 );

    private final String symbol;
    private IntBinaryOperator expression;

    OperationType(String symbol, IntBinaryOperator expression) {
        this.symbol = symbol;
        this.expression = expression;
    }
    public static OperationType of(final String symbol) {
        return Arrays.stream(OperationType.values())
                .filter(operationType -> operationType.symbol.equals(symbol))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public int calculate(int value1, int value2) { return expression.applyAsInt(value1, value2); }

}