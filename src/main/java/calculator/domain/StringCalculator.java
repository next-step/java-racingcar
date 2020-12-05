package calculator.domain;

import java.util.*;
import java.util.stream.Collectors;

public class StringCalculator {
    private static final String SPLIT_TEXT = " ";
    private final String expression;

    public StringCalculator(final String expression) {
        validate(expression);
        this.expression = expression;
    }

    public double calculate() {
        Queue<String> expressions = Arrays.stream(expression.split(SPLIT_TEXT))
                .collect(Collectors.toCollection(LinkedList::new));

        Calculator calculator = new Calculator();
        double sum = expressions.size() == 0 ? 0 : Double.parseDouble(expressions.poll());
        while (!expressions.isEmpty()) {
            String operator = expressions.poll();
            double num = Double.parseDouble(Objects.requireNonNull(expressions.poll()));
            sum = calculator.calculate(operator, sum, num);
        }
        return sum;
    }

    private void validate(final String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("사칙연산 형식대로 입력해 주세요.");
        }
    }
}
