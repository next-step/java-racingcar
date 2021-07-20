package calculator.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLE("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operation(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Integer apply(String operator, Integer num1, Integer num2) {
        return getOperator(operator).expression.apply(num1, num2);
    }

    public static Operation getOperator(String s) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(s))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
