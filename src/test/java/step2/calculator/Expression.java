package step2.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Expression {
    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> a / b);

    private String label;
    private BiFunction<Integer, Integer, Integer> calculate;

    Expression(String label, BiFunction<Integer, Integer, Integer> calculate) {
        this.label = label;
        this.calculate = calculate;
    }

    static public Expression of(String label) {
        return Arrays.stream(values()).filter(expression -> expression.label.equals(label)).findFirst().orElseThrow(IllegalArgumentException::new);
    }

    public int calculate(int a, int b) {
        return calculate.apply(a, b);
    }

}
