package calculator;

import java.util.function.IntBinaryOperator;

public class Operator {

    public static IntBinaryOperator plus = Integer::sum;
    public static IntBinaryOperator minus = (number1, number2) -> number1 - number2;
    public static IntBinaryOperator multiply = (number1, number2) -> number1 * number2;
    public static IntBinaryOperator divide = (number1, number2) -> {
        if ((number1 / number2) == (number1 / (double) number2)) {
            return number1 / number2;
        }

        throw new ArithmeticException("나눗셈의 결과는 정수이어야 합니다.");
    };

    public static IntBinaryOperator find(String operator) {
        if (operator.equals("+")) {
            return plus;
        }

        if (operator.equals("-")) {
            return minus;
        }

        if (operator.equals("*")) {
            return multiply;
        }

        if (operator.equals("/")) {
            return divide;
        }

        throw new IllegalArgumentException("잘못된 연산자");
    }
}
