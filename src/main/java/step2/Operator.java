package step2;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (Integer left, Integer right) -> left + right),
    SUBTRACT("-", (Integer left, Integer right) -> left - right),
    MULTIPLY("*", (Integer left, Integer right) -> left * right),
    DIVISION("/", (Integer left, Integer right) -> {
        assertZero(right);
        return left / right;
    });

    private static void assertZero(int right) {
        if(right == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    private String symbol;
    private BiFunction<Integer, Integer, Integer> calculation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    public int calculate(int left, int right) {
        return calculation.apply(left, right);
    }
}
