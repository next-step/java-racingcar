package calculator;

import java.util.Collections;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (first, second) -> first - second),
    MULTIPLY("*", (first, second) -> first * second),
    DIVIDE("/", (first, second) -> {
        if (second == 0) {
            throw new IllegalArgumentException();
        }

        return first / second;
    });

    private static final Map<String, Operator> operatorMap = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(Operator::getSymbol, operator -> operator)));
    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    private String getSymbol() {
        return symbol;
    }

    public int operate(int first, int second) {
        return operation.apply(first, second);
    }

    public static Operator findOperator(String symbol) {
        Operator operator = operatorMap.get(symbol);

        if (operator == null) {
            throw new IllegalArgumentException();
        }

        return operator;
    }
}

