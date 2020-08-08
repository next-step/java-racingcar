package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    protected String getOperator() {
        return operator;
    }

    protected Integer apply(int x, int y) {
        return expression.apply(x, y);
    }

    protected static Operator toOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter( op -> op.getOperator().equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("연산자가 올바르지 않습니다."));
    }

}