package calculator;

import static calculator.Operator.PLUS;

public class StringCalculator {

    public int calculate(String input) {
        checkInput(input);

        input = input.trim();

        int acc = 0;
        Operator operator = PLUS;

        for (String s : input.split(" ")) {
            if (isOperand(s)) {
                acc = operator.operate(acc, Integer.parseInt(s));
                continue;
            }

            operator = Operator.of(s);
        }

        return acc;
    }

    private boolean isOperand(String operand) {
        try {
            Integer.parseInt(operand);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    private void checkInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("계산기의 입력은 null 일 수 없다.");
        }
    }
}
