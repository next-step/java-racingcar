package study.calculate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Expression {

    private static final String DELIMITER = " ";
    public static final String EXPRESSION_MUST_NOT_NULL_OR_EMPTY_EXPRESSION = "expression must not null or empty. expression: ";

    private final LinkedList<String> expression;

    public Expression(String expression) {
        validateOrElseThrow(expression);
        this.expression = Arrays.stream(expression.split(DELIMITER))
                                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static void validateOrElseThrow(String expression) {
        if (expression == null || expression.isEmpty()) {
            throw new IllegalArgumentException(EXPRESSION_MUST_NOT_NULL_OR_EMPTY_EXPRESSION + expression);
        }
    }

    public String next() {
        return expression.pollFirst();
    }

    public boolean isEmpty() {
        return expression.isEmpty();
    }
}
