package stringcalculator;

import static stringcalculator.Operation.*;

public class StringCalculator {

    public double operate(String expression) {
        validate(expression);

        double acc = 0;
        Operation operator = PLUS;

        String[] values = expression.split(" ");

        for (String s : values) {
            if (Operation.isOperator(s)) {
                operator = Operation.of(s);
                continue;
            }
            acc = operator.apply(acc, Double.parseDouble(s));
        }

        return acc;
    }

    private void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력 값은 null이거나 공백일 수 없습니다.");
        }
    }
}
