package calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Expression {

    private static final String DELIMITER = " ";

    private final Operands operands;
    private final Operators operators;

    public Expression(String strExpression) {
        String[] split = strExpression.split(DELIMITER);
        this.operands = new Operands(extractOperands(split));
        this.operators = new Operators(extractOperators(split));
        validateSize();
    }

    private void validateSize() {
        if (operands.size() != operators.size() + 1) {
            throw new IllegalArgumentException("올바르지 않은 수식입니다.");
        }
    }

    private List<String> extractOperands(String[] strExp) {
        return IntStream.range(0, strExp.length)
                .filter(i -> i % 2 == 0)
                .mapToObj(i -> strExp[i])
                .collect(Collectors.toList());
    }

    private List<String> extractOperators(String[] strExp) {
        return IntStream.range(0, strExp.length)
                .filter(i -> i % 2 == 1)
                .mapToObj(i -> strExp[i])
                .collect(Collectors.toList());
    }

    public int calculate() {
        int result = operands.get(0);
        for (int i = 0; i < operators.size(); i++) {
            Operator operator = operators.get(i);
            result = operator.operate(result, operands.get(i + 1));
        }
        return result;
    }
}
