package step2;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    private final String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public static int operate(String symbol, int x, int y) {
        if(symbol.equals(PLUS.getSymbol())) {
            return x + y;
        }

        if(symbol.equals(MINUS.getSymbol())) {
            return x - y;
        }

        if(symbol.equals(MULTIPLE.getSymbol())) {
            return x * y;
        }

        if(symbol.equals(DIVIDE.getSymbol())) {
            return x / y;
        }

        throw new IllegalArgumentException(Constants.INVALID_SYMBOL);
    }

}
