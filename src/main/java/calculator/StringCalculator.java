package calculator;

import calculator.operand.Number;
import calculator.operator.Operator;

public class StringCalculator {
    private static final String BLANK = " ";
    private static final String EMPTY_STRING = "";
    private static final int DEFAULT_OPERAND_INDEX = 0;
    private static final int START_OPERATOR_INDEX = 1;
    private static final int NEXT_OPERATOR_INDEX = 2;

    public int calculate(String input) {
        isEmpty(input);

        String[] source = toStringArray(input);
        Number preOperand = Number.intValueOf(source[DEFAULT_OPERAND_INDEX]);

        for (int i = START_OPERATOR_INDEX; i < source.length; i += NEXT_OPERATOR_INDEX) {
            Number nextOperand = Number.intValueOf(source[i + START_OPERATOR_INDEX]);
            preOperand = preOperand.calculate(Operator.getOperator(source[i]), nextOperand);
        }
        return preOperand.getValue();
    }

    private void isEmpty(final String input) {
        if (input == null || input.trim().equals(EMPTY_STRING)) {
            throw new IllegalArgumentException("wrong input value");
        }
    }

    private String[] toStringArray(final String input) {
        return input.split(BLANK);
    }
}
