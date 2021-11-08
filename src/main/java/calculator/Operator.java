package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    TIMES("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        validateDividedBy(num1, num2);
        return num1 / num2;
    });

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(String operator, int num1, int num2) {
        return getOperator(operator).expression.apply(num1, num2);
    }

    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
                .filter(op -> op.operator.equals(operator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사칙연산자가 아닙니다."));
    }

    private static void validateDividedBy(int num1, int num2) {
        if (num1 < num2) {
            throw new IllegalArgumentException("나눗셈 결과값은 정수만 허용합니다.");
        }
    }

}
