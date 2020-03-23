package stringcalculator.domain;

import java.util.LinkedList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operators {
    private LinkedList<String> operators;

    public Operators(String[] expressions) {
        if (!validate(expressions)) {
            throw new IllegalArgumentException(Constant.MUST_USE_NUMBER_OPERATOR);
        }
        this.operators = Stream.of(expressions)
                .filter(this::isOperator)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    public String get() {
        return operators.poll();
    }

    private boolean isOperator(String expression) {
        return Constant.OPERATOR_PATTERN.matcher(expression).find();
    }

    private boolean validate(String[] expressions) {
        long operatorCount = Stream.of(expressions)
                .filter(e -> e.matches(Constant.OPERATOR_PATTERN.toString()))
                .count();
        long literalCount = Stream.of(expressions)
                .filter(e -> e.matches(Constant.LITERAL_PATTERN.toString()))
                .count();

        return operatorCount == literalCount;
    }
}
