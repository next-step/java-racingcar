package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> num1 / num2);

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operation(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operation findBySymbol(String symbol) {
        return Arrays.stream(Operation.values())
                .filter(operator -> operator.operator.equals(symbol))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int result(int num1, int num2) {
        return expression.apply(num1, num2);
    }

}
