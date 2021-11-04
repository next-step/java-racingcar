package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Number::plus),
    MINUS("-", Number::minus),
    MUL("*", Number::multiply),
    DIV("/", Number::divide);

    private final String operator;
    private final BiFunction<Number, Number, Number> calculate;

    Operator(String operator, BiFunction<Number, Number, Number> calculate) {
        this.operator = operator;
        this.calculate = calculate;
    }

    public static Number calc(String operation, Number a, Number b) {
        Operator findOperator = Arrays.stream(values())
                .filter(operator -> operator.operator.equals(operation))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);

        return findOperator.calculate.apply(a, b);
    }
}
