package step2;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (num, nextNum) -> num - nextNum),
    MULTIPLY("*", (num, nextNum) -> num * nextNum),
    DIVIDE("/", (num, nextNum) -> num / nextNum);

    String symbol;
    BiFunction<Integer, Integer, Integer> operation;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> operation) {
        this.symbol = symbol;
        this.operation = operation;
    }

    public Integer operate(Integer num, Integer nextNum) {
        return operation.apply(num, nextNum);
    }

    public static Operator fromSymbol(String symbol) {
        return findSymbol(symbol)
                .orElseThrow(() -> new IllegalArgumentException("invalid symbol"));
    }

    private static Optional<Operator> findSymbol(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst();
    }

    public static boolean contains(String symbol) {
        return findSymbol(symbol).isPresent();
    }
}
