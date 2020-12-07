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
        Queue<String> expressions = splitExpression();

        double sum = Double.parseDouble(Objects.requireNonNull(expressions.poll()));
        while (!expressions.isEmpty()) {
            Operator operator = Operator.findByType(expressions.poll());
            double num = Double.parseDouble(Objects.requireNonNull(expressions.poll()));
            sum = operator.calculate(sum, num);
        }
        return sum;
    }

    private void validate(final String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("사칙연산 형식대로 입력해 주세요.");
        }
    }

    private Queue<String> splitExpression() {
        return Arrays.stream(expression.split(SPLIT_TEXT))
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
