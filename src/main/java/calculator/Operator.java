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

    public boolean compare(String operator) {
        return this.operator.equals(operator);
    }

    public static Operator of(String operator) {
        return Arrays.stream(values())
                .filter(object -> object.compare(operator))
                .findFirst()
                .orElseThrow(IllegalAccessError::new);
    }
}
