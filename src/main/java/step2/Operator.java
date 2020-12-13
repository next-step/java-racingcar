package step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (Integer left, Integer right) -> left + right),
    SUBTRACT("-", (Integer left, Integer right) -> left - right),
    MULTIPLY("*", (Integer left, Integer right) -> left * right),
    DIVISION("/", (Integer left, Integer right) -> {
        assertZero(right);
        return left / right;
    });

    private String symbol;
    private BiFunction<Integer, Integer, Integer> calculation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    public int calculate(int left, int right) {
        return calculation.apply(left, right);
    }

    public static Operator from(String symbol) {
        return Arrays.stream(values())
                .filter(value -> value.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산자에 해당하는 기호가 아닙니다."));
    }

    private static void assertZero(int right) {
        if(right == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }
}
