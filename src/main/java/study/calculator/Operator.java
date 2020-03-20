package study.calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

enum Operator {
    PLUS("+", operand -> operand.getLeftSide() + operand.getRightSide()),
    MINUS("-", operand -> operand.getLeftSide() - operand.getRightSide()),
    DIVIDE("/", operand -> {
        float rightSide = operand.getRightSide();
        if (rightSide == 0) {
            throw new IllegalArgumentException();
        }
        return operand.getLeftSide() / rightSide;
    }),
    MULTIPLY("*", operand -> operand.getLeftSide() * operand.getRightSide());

    private static Map<String, Operator> map = new HashMap<>();
    private String symbol;
    private Function<Operand, Float> operate;

    Operator(String symbol, Function<Operand, Float> operator) {
        this.symbol = symbol;
        this.operate = operator;
    }

    static {
        for (Operator operator : Operator.values()) {
            map.put(operator.symbol, operator);
        }
    }

    public static Operator symbolOf(String symbol) {
        return map.get(symbol);
    }

    public float run(Operand operand) {
        return this.operate.apply(operand);
    }
}
