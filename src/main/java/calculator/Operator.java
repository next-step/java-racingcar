package calculator;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION("+", Long::sum),
    SUBTRACTION("-", (o1, o2) -> o1 - o2),
    MULTIPLICATION("*", (o1, o2) -> o1 * o2),
    DIVISION("/", (o1, o2) -> {
        if (o2.equals(0L)) {
            throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
        }
        return o1 / o2;
    })
    ;

    private final String symbol;
    private final BiFunction<Long, Long, Long> calculationFunction;

    Operator(String symbol, BiFunction<Long, Long, Long> calculationFunction) {
        this.symbol = symbol;
        this.calculationFunction = calculationFunction;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.getSymbol().equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("해당 symbol에 대한 Operator가 존재하지 않습니다"));
    }

    public String getSymbol() {
        return symbol;
    }

    public Long calculate(Long operand1, Long operand2) {
        return calculationFunction.apply(operand1, operand2);
    }
}
