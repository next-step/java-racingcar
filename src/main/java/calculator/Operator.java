package calculator;

public enum Operator {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }


public static Operator findBySymbol(String symbol) {
        return Arrays.stream(values()).filter(val -> val.symbol.equals(symbol)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}

