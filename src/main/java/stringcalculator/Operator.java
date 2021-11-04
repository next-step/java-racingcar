package stringcalculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (first, second) -> Number.from(first.getNumber() + second.getNumber())),
    MINUS("-", (first, second) -> Number.from(first.getNumber() - second.getNumber())),
    MUL("*", (first, second) -> Number.from(first.getNumber() * second.getNumber())),
    DIV("/", (first, second) -> Number.from(first.getNumber() / second.getNumber()));

    private final String symbol;
    private final BiFunction<Number, Number, Number> calculate;

    Operator(String symbol, BiFunction<Number, Number, Number> calculate) {
        this.symbol = symbol;
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
