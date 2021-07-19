package calculator;

import java.util.function.Function;

public class Operator {

    public static Function<int[], Integer> plus = numbers -> numbers[0] + numbers[1];
    public static Function<int[], Integer> minus = numbers -> numbers[0] - numbers[1];
    public static Function<int[], Integer> multiply = numbers -> numbers[0] * numbers[1];
    public static Function<int[], Integer> divide = numbers -> {
        if ((numbers[0] / numbers[1]) == (numbers[0] / (double) numbers[1])) {
            return numbers[0] / numbers[1];
        }

        throw new ArithmeticException("나눗셈의 결과는 정수이어야 합니다.");
    };

    public static Function<int[], Integer> find(String operator) {
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
