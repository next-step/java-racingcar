package operator;

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
        if (ADDITION.symbol.equals(symbol)) {
            return ADDITION;
        }
        if (SUBTRACTION.symbol.equals(symbol)) {
            return SUBTRACTION;
        }
        if (MULTIPLICATION.symbol.equals(symbol)) {
            return MULTIPLICATION;
        }
        if (DIVIDE.symbol.equals(symbol)) {
            return DIVIDE;
        }
        throw new IllegalArgumentException();
    }

    public int apply(int x, int y) {
        return operator.apply(x, y);
    }

}
