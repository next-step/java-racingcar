package calculator.operator;

import java.util.Arrays;

public enum Operation {

    ADDITION(("+"), (x, y) -> x + y),
    SUBTRACTION(("-"), (x, y) -> x - y),
    MULTIPLICATION(("*"), (x, y) -> x * y),
    DIVIDE(("/"), (x, y) -> x / y);

    private final String symbol;
    private final Operator operator;

    Operation(String symbol, Operator operator) {
        this.symbol = symbol;
        this.operator = operator;
    }

    public static Operation getOperation(String symbol) {
        return Arrays.stream(Operation.values()).filter(operation -> operation.symbol.equals(symbol))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("해당하는 연산자가 존재하지 않습니다."));
    }

    public int apply(int x, int y) {
        return operator.apply(x, y);
    }

}
