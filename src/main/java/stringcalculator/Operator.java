package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> Number.from(a.getNumber() + b.getNumber())),
    MINUS("-", (a, b) -> Number.from(a.getNumber() - b.getNumber())),
    MUL("*", (a, b) -> Number.from(a.getNumber() * b.getNumber())),
    DIV("/", (a, b) -> Number.from(a.getNumber() / b.getNumber()));

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
                .orElseThrow(NotFoundOperatorException::new);

        return findOperator.calculate.apply(a, b);
    }
}
