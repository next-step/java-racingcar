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

    public static int calculate2(String s) {

        String[] values = s.split(" ");
        Number first = new Number(values[0]);
        Number second = new Number(values[2]);

        return calculate2(first, values[1], second).getNumber();
    }

    private static Number calculate2(Number first, String operator, Number second) {

        if ("+".equals(operator))
            return first.plus(second);

        if ("-".equals(operator))
            return first.minus(second);

        if ("*".equals(operator))
            return first.times(second);

        if ("/".equals(operator))
            return first.dividedBy(second);

        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}


