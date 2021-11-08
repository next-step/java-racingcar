package step2;

public class StringCalculator {
    public static CalculatorNumber calculate(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException("빈 문자열 혹은 null은 입력할 수 없습니다.");
        }

        String[] elements = expression.split(" ");

        CalculatorNumber result = new CalculatorNumber(0);
        Operator operator = Operator.PLUS;
        for (int i = 0; i < elements.length; i++) {
            if (i % 2 == 0) {
                result = operator.operate(result, new CalculatorNumber(elements[i]));
            } else {
                operator = Operator.findByValue(elements[i]);
            }
        }

        return result;
    }
}
