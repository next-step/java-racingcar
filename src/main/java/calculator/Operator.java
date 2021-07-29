package calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public String getSymbol() {
        return symbol;
    }

    public BiFunction<Integer, Integer, Integer> getExpression() {
        return expression;
    }

    public static Operator operatorOf(String symbol) {
        if (PLUS.symbol.equals(symbol)) {
            return PLUS;
        }
        if (MINUS.symbol.equals(symbol)) {
            return MINUS;
        }
        if (MULTIPLY.symbol.equals(symbol)) {
            return MULTIPLY;
        }
        if (DIVIDE.symbol.equals(symbol)) {
            return DIVIDE;
        }
        throw new IllegalArgumentException();
    }

    public int calculate(int num1, int num2) {
        return expression.apply(num1, num2);
    }
}
