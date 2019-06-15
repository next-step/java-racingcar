package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum  Operator {
    ADD("+", Integer::sum),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operation;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operation, BiFunction<Integer, Integer, Integer> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    public int getResult(int num1, int num2) {
        return expression.apply(num1, num2);
    }

    public static Operator getInstance(String op) {
        return Arrays.stream(Operator.values())
                .filter(operator -> op.equals(operator.operation))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
