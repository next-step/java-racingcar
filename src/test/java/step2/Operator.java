package step2;

import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

public enum Operator {

    PLUS("+", Integer::sum),
    MINUS("-", (i, j) -> i - j),
    MULTIPLY("*", (i, j) -> i * j),
    DIVIDE("/", (i, j) -> i / j);

    private final String operator;
    private final IntBinaryOperator functionByOperator;

    Operator(String operator, IntBinaryOperator functionByOperator) {
        this.operator = operator;
        this.functionByOperator = functionByOperator;
    }
    public static int execute(ComputationalInformation information) {
        return Stream.of(Operator.values())
                .filter(value->value.operator.equals(information.getOperator()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                .functionByOperator
                .applyAsInt(information.getPreviousValue(), information.getAfterValue());
    }
}
