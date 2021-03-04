package calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {
    private final List<Integer> operands;
    private final List<Operator> operators;

    public StringCalculator() {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public int calculate(String value) {
        if (StringUtil.isBlank(value)) throw new IllegalArgumentException();

        setSymbolsWith(value);

        return calculateSymbols();
    }

    private void setSymbolsWith(String value) {
        final String[] symbolCandidates = value.split(" ");

        for (final String candidate : symbolCandidates) {
            if (IntegerUtil.isInteger(candidate)) {
                operands.add(Integer.parseInt(candidate));
            } else if (Operator.isOperator(candidate)) {
                operators.add(Operator.parseOperator(candidate));
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private int calculateSymbols() {
        int result = operands.get(0);

        for (int i = 1; i < operands.size(); i++) {
            final Operator operator = operators.get(i - 1);
            final int operand = operands.get(i);

            result = operator.calculate(result, operand);
        }

        return result;
    }
}
