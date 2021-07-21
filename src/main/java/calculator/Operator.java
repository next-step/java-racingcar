package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTIPLY("*", (x, y) -> x * y),
    DIVISION("/", (x, y) -> x / y);

    public static final String DIVIDE_ZERO_ERROR_MESSAGE = "0으로 나눌 수 없습니다.";

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 연산자입니다."));
    }

    public int calculate(int oriNumber, int inputNumber) {
        if (operator.equals(DIVISION.operator) && inputNumber == 0) {
            throw new IllegalArgumentException(DIVIDE_ZERO_ERROR_MESSAGE);
        }
        return expression.apply(oriNumber, inputNumber);
    }

}
