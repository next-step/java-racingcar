package calculator;

import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num1 == 0 || num2 == 0) {
            return 0;
        }
        return num1 / num2;
    });

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> bf;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> bf) {
        this.symbol = symbol;
        this.bf = bf;
    }

    public String getSymbol() {
        return symbol;
    }

    public int exec(int num1, int num2) {
        return bf.apply(num1, num2);
    }

    public static Operator of(String symbol) {
        Operator[] operators = Operator.values();
        for (Operator operator : operators) {
            if(operator.getSymbol().equals(symbol)){
                return operator;
            }
        }
        throw new IllegalArgumentException("Invalid value : " + symbol);
    }
}
