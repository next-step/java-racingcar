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
            MyNumber first = new MyNumber(expression.pollFirst());
            String operator = expression.pollFirst();
            MyNumber second = new MyNumber(expression.pollFirst());

            expression.addFirst(first.add(second).toString());
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
