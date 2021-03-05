package calculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Calculator {

    private static final String DELIMITER = " ";

    public int calculate(String expression) {
        validate(expression);

        Queue<String> tokens = new ArrayDeque<>(Arrays.asList(expression.split(DELIMITER)));
        int accumulator = Integer.parseInt(tokens.remove());

        while (!tokens.isEmpty()) {
            Operator operator = Operator.createOperator(tokens.remove());
            int rhs = Integer.parseInt(tokens.remove());

            accumulator = operator.calculation.apply(accumulator, rhs);
        }

        return accumulator;
    }

    private void validate(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("수식이 입력되지 않았습니다. 올바른 수식을 다시 입력해주세요.");
        }
    }

}
