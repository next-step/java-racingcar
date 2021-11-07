package calculator;

public class Calculator {
    public static int calculate(String expression) {

        String[] values = expression.split(" ");
        Number first = new Number(values[0]);
        Number second = new Number(values[2]);

        return calculate(first, values[1], second).getNumber();
    }

    private static Number calculate(Number first, String operator, Number second) {

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


