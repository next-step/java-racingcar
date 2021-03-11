package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCalculator {
    private final List<Integer> operands;
    private final List<Operator> operators;

    public StringCalculator() {
        operands = new ArrayList<>();
        operators = new ArrayList<>();
    }

    public int calculate(String value) {
        if (StringUtil.isBlank(value)) {
            throw new IllegalArgumentException();
        }

        final String[] symbolCandidates = value.split(" ");

        if (containsNotSymbol(symbolCandidates)) {
            throw new IllegalArgumentException();
        }
        setOperandsWith(symbolCandidates);
        setOperatorsWith(symbolCandidates);

        return calculateSymbols();
    }

    private boolean containsNotSymbol(String[] symbolCandidates) {
        return Arrays.stream(symbolCandidates)
                .anyMatch(e -> !IntegerUtil.isInteger(e) && !Operator.isOperator(e));
    }

    private void setOperandsWith(String[] operandCandidates) {
        operands.addAll(
                Arrays.stream(operandCandidates)
                        .filter(IntegerUtil::isInteger)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
        );
    }

    private void setOperatorsWith(String[] operatorsCandidates) {
        operators.addAll(
                Arrays.stream(operatorsCandidates)
                        .filter(Operator::isOperator)
                        .map(Operator::parseOperator)
                        .collect(Collectors.toList())
        );
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
