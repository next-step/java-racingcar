package study.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiFunction;

enum Operator {
    PLUS("+", Double::sum),
    MINUS("-", (leftSide, rightSide) -> leftSide - rightSide),
    DIVIDE("/", (leftSide, rightSide) -> {
        if (rightSide == 0) {
            throw new IllegalArgumentException();
        }
        return leftSide / rightSide;
    }),
    MULTIPLY("*", (leftSide, rightSide) -> leftSide * rightSide);

    private static Map<String, Operator> map = new HashMap<>();
    private String symbol;
    private BiFunction<Double, Double, Double> operate;

    Operator(String symbol, BiFunction<Double, Double, Double> operator) {
        this.symbol = symbol;
        this.operate = operator;
    }

    static {
        for (Operator operator : Operator.values()) {
            map.put(operator.symbol, operator);
        }
    }

    public static Operator symbolOf(String symbol) {
        Operator operator = map.get(symbol);
        if (Objects.isNull(operator)) {
            throw new IllegalArgumentException();
        }

        return operator;
    }

    public double run(double leftSide, double rightSide) {
        return this.operate.apply(leftSide, rightSide);
    }
}
