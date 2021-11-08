package step2;

import java.util.List;

public class Calculator {
    public static int calculate(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException("빈 문자열 혹은 null은 입력할 수 없습니다.");
        }

        String[] elements = expression.split(" ");
        int first = Integer.parseInt(elements[0]);
        String operator = elements[1];
        int second = Integer.parseInt(elements[2]);

        if ("+".equals(operator)) {
            return first + second;
        }
        if ("-".equals(operator)) {
            return first - second;
        }
        if ("*".equals(operator)) {
            return first * second;
        }
        if ("/".equals(operator)) {
            return first / second;
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}
