package step2.enums;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (x, y) -> x + y),
    SUBTRACTION("-", (x, y) -> x - y),
    MULTIPLICATION("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> x / y);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    boolean isTarget(String input) {
        return symbol.equals(input);
    }

    public int calculate(int x, int y) {
        return expression.apply(x, y);
    }

    public static boolean isOperator(String input) {
        return Arrays.stream(values())
                .anyMatch(operator -> operator.isTarget(input));
    }

    public static Operator findOperatorByString(String input) {
        return Arrays.stream(values())
                .filter(operator -> operator.isTarget(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

}
