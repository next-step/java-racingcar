package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x,y) -> x + y),
    MINUS("-", (x,y) -> x - y),
    TIMES("*", (x,y) -> x * y),
    DIVIDE("/", (x,y) -> {
        if(y == 0) throw new IllegalArgumentException("can't divide with 0");
        return x / y;
    });

    private final String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
            this.symbol = symbol;
            this.expression = expression;
    }

    public int operate(int x, int y){
        return expression.apply(x,y);
    }

    public static boolean isOperator(String symbol) {
        return Arrays.stream(values()).anyMatch((o) -> o.symbol.equals(symbol));
    }

    public static Operator get(String symbol) {
        return Arrays.stream(values()).filter((o) -> o.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("variable is not operator"));
    }
}