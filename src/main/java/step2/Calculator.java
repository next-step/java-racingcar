package step2;

public class Calculator {
    public static CalculatorNumber calculate(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException("빈 문자열 혹은 null은 입력할 수 없습니다.");
        }

        String[] elements = expression.split(" ");
        CalculatorNumber first = new CalculatorNumber(elements[0]);
        String operator = elements[1];
        CalculatorNumber second = new CalculatorNumber(elements[2]);

        if ("+".equals(operator)) {
            return first.plus(second);
        }
        if ("-".equals(operator)) {
            return first.minus(second);
        }
        if ("*".equals(operator)) {
            return first.times(second);
        }
        if ("/".equals(operator)) {
            return first.divideBy(second);
        }
        throw new IllegalArgumentException("사칙연산 기호가 아닙니다.");
    }
}
