package calculator;

import java.util.Objects;

public class StringCalculator {

    public static int add(int x, int y) {
        return x + y;
    }

    public static int minus(int x, int y) {
        return x - y;
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public static int divide(int x, int y) {
        return x / y;
    }

    public static String[] splitExpression(String expression) {
        if (Objects.isNull(expression) || expression.isEmpty()) {
            throw new IllegalArgumentException("null 또는 빈 공백의 문자열입니다.");
        }
        return null;
    }
}
