package stringcalculator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class StringCalculator {
    private Deque<String> expression;
    private static final String DELIMITER = " ";

    public int calculate(String input) {
        initExpression(input);
        while (hasNextOperation()) {
            int first = Integer.parseInt(expression.pollFirst());
            String operator = expression.pollFirst();
            int second = Integer.parseInt(expression.pollFirst());

            expression.addFirst(Integer.toString(first + second));
        }

        return Integer.parseInt(expression.poll());
    }

    public void initExpression(String input) {
        expression = new ArrayDeque<>(Arrays.asList(input.split(DELIMITER)));
    }

    private boolean hasNextOperation() {
        return this.expression.size() > 1;
    }
}
