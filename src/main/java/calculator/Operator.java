package calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntBinaryOperator;

public enum Operator {

    PLUS('+', Integer::sum),
    MINUS('-', (left, right) -> left - right),
    MULTIPLY('*', (left, right) -> left * right),
    DIVIDE('/', (left, right) -> left / right)

    ;

    private static final Map<Character, Operator> OPERATOR_BY_SYMBOL;

    static {
        OPERATOR_BY_SYMBOL = new HashMap<>();
        for (Operator operator : values()) {
            OPERATOR_BY_SYMBOL.put(operator.symbol, operator);
        }
    }

    private final char symbol;
    private final IntBinaryOperator operator;

    Operator(char symbol, IntBinaryOperator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public int apply(int left, int right) {
        return operator.applyAsInt(left, right);
    }

    public static int calculate(char symbol, int left, int right) {
        Operator operator = OPERATOR_BY_SYMBOL.get(symbol);
        if (operator == null) {
            throw new IllegalArgumentException("unknown operator symbol: " + symbol);
        }

        return OPERATOR_BY_SYMBOL.get(symbol)
                .apply(left, right);
    }
}
