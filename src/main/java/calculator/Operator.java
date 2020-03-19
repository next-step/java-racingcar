package calculator;

import java.util.stream.Stream;

public enum Operator {
    PLUS("+", new Plus()),
    MINUS("-", new Minus()),
    MULTIPLY("*", new Multiply()),
    DIVIDE("/", new Divide());

    String symbol;
    Operable operable;

    Operator(String symbol, Operable operable) {
        this.symbol = symbol;
        this.operable = operable;
    }

    public static Operator of(String symbol) {
        return Stream.of(Operator.values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("부적절한 기호 입니다."));
    }

    public int operate(int leftOp, int rightOp) {
        return operable.operate(leftOp, rightOp);
    }
}
