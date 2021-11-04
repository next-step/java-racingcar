package calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", Num::plus),
    SUBTRACTION("-", Num::minus),
    MULTIPLICATION("*", Num::times),
    DIVISION("/", Num::divideBy);

    private final String operator;
    private final BiFunction<Num, Num, Num> operation;

    Operator(String operator, BiFunction<Num, Num, Num> operation) {
        this.operator = operator;
        this.operation = operation;
    }
    public Num operate(Num first, Num second) {
        return operation.apply(first, second);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
