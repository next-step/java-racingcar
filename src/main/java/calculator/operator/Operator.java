package calculator.operator;

import java.util.function.BiFunction;

public enum Operator {
    ADD(Math::addExact),
    SUB(Math::subtractExact),
    MUL(Math::multiplyExact),
    DIV(Math::floorDiv);

    Operator(BiFunction<Integer, Integer, Integer> function) {
        this.function = function;
    }

    private final BiFunction<Integer, Integer, Integer> function;

    public int operate(int x, int y) {
        return function.apply(x, y);
    }
}
