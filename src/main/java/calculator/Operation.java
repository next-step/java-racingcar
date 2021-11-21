package calculator;

import java.util.Arrays;
import java.util.function.IntBinaryOperator;

public enum Operation {

     ADDITION       ("+", (first, second) -> first + second)
    ,SUBTRACTION    ("-", (first, second) -> first - second)
    ,MULTIPLICATION ("*", (first, second) -> first * second)
    ,DIVISION       ("/", (first, second) -> first / second);

    private String symbol;
    private IntBinaryOperator operator;

    Operation(String symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public int execute(int first, int second) {
        return operator.applyAsInt(first, second);
    }

    public static Operation findOf(String symbol) {
        return Arrays.stream(Operation.values())
                .filter(shape -> shape.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
