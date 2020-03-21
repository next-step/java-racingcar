package calculator;

import java.util.Objects;

public class StringCalculator {
    public int stringCalculate(String input) {
        if(Objects.isNull(input) || input.isEmpty()) {
            throw new IllegalArgumentException("입력값이 null이거나 빈 공백");
        }

        String [] formula = input.split(" ");
        int result = Integer.valueOf(formula[0]);
        for(int idx = 1; idx < formula.length - 1; idx += 2) {
            result = operate(formula[idx], result, Integer.valueOf(formula[idx + 1]));
        }

        return result;
    }

    public int operate(String symbol, int left, int right) {
        switch (symbol) {
            case "+":
                return Calculator.plus(left, right);
            case "-":
                return Calculator.minus(left, right);
            case "*":
                return Calculator.multiply(left, right);
            case "/":
                return Calculator.division(left, right);
            default:
                throw new IllegalArgumentException("사칙연산 기호가 아님: " + symbol);
        }
    }
}
