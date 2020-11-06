package calculator;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.BiFunction;

public enum Operator {

    ADDITION("+", Integer::sum),
    SUBTRACTION("-", (val1, val2) -> val1 - val2),
    MULTIPLY("*", (val1, val2) -> val1 * val2),
    DIVIDE("/", (num1, num2) -> {
        checkParameterIsZero(num1, num2);
        return num1 / num2;
    });

    private static final int ZERO = 0;
    private static final String CANT_DIVIDE_ZERO = "0으로 나눌 수 없습니다.";
    private static final String EMPTY_EXPRESSION = "계산 문자열이 잘못 되었습니다.";
    private static final String WRONG_OPERATOR = "연산자가 잘못 되었습니다.";

    private static void checkParameterIsZero(int num1, int num2) {
        if (num1 == ZERO || num2 == ZERO) {
            throw new ArithmeticException(CANT_DIVIDE_ZERO);
        }
    }

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(final String operator, final BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public int calculate(final int num1, final int num2) {
        return expression.apply(num1, num2);
    }

    public static Operator getOperator(final String type) {
        if (Objects.isNull(type) || type.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_EXPRESSION);
        }

        return Arrays.stream(Operator.values())
                .filter(inputValue -> type.contains(inputValue.operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(WRONG_OPERATOR));
    }
}

