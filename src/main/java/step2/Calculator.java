package step2;

public class Calculator {
    public static CalculatorNumber calculate(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException("빈 문자열 혹은 null은 입력할 수 없습니다.");
        }

        String[] elements = expression.split(" ");
        CalculatorNumber first = new CalculatorNumber(elements[0]);
        Operator operator = Operator.findByValue(elements[1]);
        CalculatorNumber second = new CalculatorNumber(elements[2]);

        return operator.operate(first, second);
    }
}
