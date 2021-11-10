package study.step2;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (first, second) -> first.plus(second)),
    SUBTRACTION("-", (first, second) -> first.minus(second)),
    MULTIPLICATION("*", (first, second) -> first.times(second)),
    DIVISION("/", (first, second) -> first.dividedBy(second));

    public String operator;
    public BiFunction<Number, Number, Number> operation;

    Operator(String operator, BiFunction<Number, Number, Number> operation){
        this.operator = operator;
        this.operation = operation;
    }

    public Number operate(Number first, Number second){
        return operation.apply(first, second);
    }

    public static Operator operator(String Operator) {
        return Arrays.stream(values())
            .filter(o -> o.operator.equals(Operator))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException(String.format("사칙연산 기호가 아닙니다.")));
    }
}
