package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", (first, second) -> first.plus(second)),
    SUBTRACTION("-", (first, second) -> first.minus(second)),
    MULTIPLICATION("*", (first, second) -> first.times(second)),
    DIVISION("/", (first, second) -> first.divideBy(second));

    private String operator;
    private BiFunction<MyNumber, MyNumber, MyNumber> operation;

    Operator(String operator, BiFunction<MyNumber, MyNumber, MyNumber> operation) {
        this.operator = operator;
        this.operation = operation;
    }

    public MyNumber operate(int first, int second) {
        return operate(new MyNumber(first), new MyNumber(second));
    }

    public MyNumber operate(MyNumber first, MyNumber second) {
        return operation.apply(first, second);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
