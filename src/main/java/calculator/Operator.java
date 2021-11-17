package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (first, second) -> first.plus(second)),
    MINUS("-", (first, second) -> first.minus(second)),
    MULTIPLE("*", (first, second) -> first.multiple(second)),
    DIVIDE("/", (first, second) -> first.divideBy(second));

    private String operation;
    private BiFunction<MyNumber, MyNumber, MyNumber> expression;

    Operator(String operation, BiFunction<MyNumber, MyNumber, MyNumber> expression) {
        this.operation = operation;
        this.expression = expression;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(operation -> operation.hasOperation(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙 연산 기호가 아닙니다."));
    }

    public boolean hasOperation(String symbol) {
        return operation.equals(symbol);
    }

    public MyNumber calculate(MyNumber first, MyNumber second) {
        return expression.apply(first, second);
    }
}
