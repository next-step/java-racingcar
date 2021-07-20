package calculator.operator;

import java.util.Arrays;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Operator {
    ADDITION("+", Math::addExact),
    SUBTRACTION("-", Math::subtractExact),
    MULTIPLICATION("*", Math::multiplyExact),
    DIVISION("/", Math::floorDiv);

    private static final Map<String, Operator> OPERATORS =
            Arrays.stream(Operator.values())
                    .collect(Collectors.toMap(Operator::getSymbol, Function.identity()));

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> function;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> function) {
        this.symbol = symbol;
        this.function = function;
    }

    public static Operator of(String symbol) {
        if (!OPERATORS.containsKey(symbol)) {
            throw new IllegalArgumentException("Unsupported operator :" + symbol);
        }

        return OPERATORS.get(symbol);
    }

    public int operate(int x, int y) {
        return function.apply(x, y);
    }

    private String getSymbol() {
        return this.symbol;
    }
}
