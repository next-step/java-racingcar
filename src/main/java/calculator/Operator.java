package calculator;

import java.util.function.BiFunction;

public enum Operator {
    ADDITION((a, b) -> a + b),
    SUBTRACTION((a, b) -> a - b),
    MULTIPLICATION((a, b) -> a * b),
    DIVISION((a, b) -> a / b);

    final private BiFunction<Integer, Integer, Integer> calcFunc;

    Operator(BiFunction<Integer, Integer, Integer> calcFunc) {
        this.calcFunc = calcFunc;
    }

    public int calculate(int a, int b) {
        return calcFunc.apply(a, b);
    }
}

