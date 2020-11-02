package stringcalculator;

import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (val1, val2) -> val1 + val2),
    MINUS("+", (val1, val2) -> val1 - val2),
    MULTIPLY("+", (val1, val2) -> val1 * val2),
    DIVIDE("+", (val1, val2) -> val1 / val2);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public String getOperator() {
        return operator;
    }

    public int calculate(int val1, int val2) {
        return expression.apply(val1, val2);
    }

}
