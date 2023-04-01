package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

public enum Operator {
    ADD("+", (num1, num2) -> num1 + num2),
    SUBSTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", new BiFunction<Integer, Integer, Integer>() {
        @Override
        public Integer apply(Integer num1, Integer num2) {
            if (num2 == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return num1 / num2;
        }
    });

    private String operator;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static int calculate(int num1, int num2, String operator) {
        return getOperator(operator).expression.apply(num1, num2);
    }
    private static Operator getOperator(String operator) {
        return Arrays.stream(values())
            .filter(operators -> operators.operator.equals(operator))
            .findFirst()
            .orElseThrow(IllegalArgumentException::new);
    }
}
