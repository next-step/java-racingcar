package study.step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> {
        if (x % y != 0) {
            throw new IllegalArgumentException(CalculatorError.DIVIDE_RESULT_MUST_INTEGER);
        }
        return x / y;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(final String operator, final BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int execute(Integer num1, String operator, Integer num2) {
        return Arrays.stream(Operator.values())
                .filter(i -> i.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(CalculatorError.UNSUPPORTED_OPERATOR))
                .expression.apply(num1, num2);
    }
}
