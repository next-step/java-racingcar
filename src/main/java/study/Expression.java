package study;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Expression {

    private static final String DELIMITER = " ";

    private final LinkedList<String> expression;

    public Expression(String expression) {
        validateOrElseThrow(expression);
        this.expression = Arrays.stream(expression.split(DELIMITER))
                                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static void validateOrElseThrow(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException("expression must not null or empty. expression: " + expression);
        }
    }

    public String next() {
        return expression.pollFirst();
    }

    public boolean isEmpty() {
        return expression.isEmpty();
    }
}
