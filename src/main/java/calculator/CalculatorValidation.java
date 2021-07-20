package calculator;

public class CalculatorValidation {

    final String[] expression = {"+", "-", "*", "/"};


    public void checkException(String expression, int lastValue) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("연산 수식이 null 입니다.");
        }
        if (expression.isEmpty()) {
            throw new IllegalArgumentException("연산 수식이 빈값 입니다.");
        }
        if (lastValue == 0) {
            throw new IllegalStateException("0으로 나눗셈은 불가능합니다.");
        }
    }


}
