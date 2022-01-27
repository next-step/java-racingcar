package calculator.domain;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (num1, num2) -> num1 + num2),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        Validator.validateIndivisibleNumber(num2);
        return num1 / num2;
    });

    private static final Operator NON_EXISTNT = null;
    private String symbol;
    private BiFunction<Double, Double, Double> operate;

    Operator(String symbol, BiFunction<Double, Double, Double> operate) {
        this.symbol = symbol;
        this.operate = operate;
    }

    public static boolean contains(String symbol) {
        return get(symbol) != NON_EXISTNT;
    }

    public static Operator get(String symbol) {
        for (Operator op : Operator.values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        return null;
    }

    public double operate(double num1, double num2) {
        return this.operate.apply(num1, num2);
    }
}
