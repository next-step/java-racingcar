package step2;

import java.util.Arrays;

public enum Operator {
    PLUS("+", (a, b) -> a + b),
    SUB("-", (a, b) -> a - b),
    DIV("/", (a, b) -> a / b),
    MUL("*", (a, b) -> a * b);

    private final String symbol;

    private final OperatorInterface operations;

    Operator(String symbol, OperatorInterface operations) {
        this.symbol = symbol;
        this.operations = operations;
    }

    public static Operator of(String param) {
        return Arrays.stream(Operator.values())
                .filter(operator -> operator.symbol.equals(param))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("사칙연산 기호가 아닙니다."));
    }

    public int apply(int a, int b) {
        return this.operations.apply(a, b);
    }
}
