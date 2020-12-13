package step2;

import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (Integer num1, Integer num2) -> num1 + num2),
    SUBTRACT("-", (Integer num1, Integer num2) -> num1 - num2),
    MULTIPLY("*", (Integer num1, Integer num2) -> num1 * num2),
    DIVISION("/", (Integer num1, Integer num2) -> {
        assertZero(num2);
        return num1 / num2;
    });

    private static void assertZero(int num2) {
        if(num2 == 0) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
    }

    private String symbol;
    private BiFunction<Integer, Integer, Integer> calculation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calculation) {
        this.symbol = symbol;
        this.calculation = calculation;
    }

    public int calculate(int num1, int num2) {
        return calculation.apply(num1, num2);
    }
}
