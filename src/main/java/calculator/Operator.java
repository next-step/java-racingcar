package calculator;

import java.util.function.BiFunction;

public enum Operator {
    ADDTION("+", (num1, num2) -> (num1 + num2)),
    SUBTRACT("-", (num1, num2) -> (num1 - num2)),
    MULTIPLICATION("*", (num1, num2) -> (num1 * num2)),
    DIVISION("/", (num1, num2) -> (num1 / num2));

    private final String name;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String name, BiFunction<Integer, Integer, Integer> expression) {
        this.name = name;
        this.expression = expression;
    }

    public Integer calculate(Integer num1, Integer num2) {
        return this.expression.apply(num1, num2);
    }
}
