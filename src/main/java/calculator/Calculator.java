package calculator;

public class Calculator {

    public static int calculate(String s) {

        String[] values = s.split(" ");

        int first = Integer.parseInt(values[0]);
        String operator = values[1];
        int second = Integer.parseInt(values[2]);

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
            if (second == 0) {
                throw new IllegalArgumentException("분모는 0이 될 수 없습니다.");
            }
            return first / second;
        }

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}


