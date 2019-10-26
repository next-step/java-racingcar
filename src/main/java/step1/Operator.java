package step1;

public enum Operator {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    public static Operator getOperator(String symbol) {
        for (Operator op : values()) {
            if (op.symbol.equals(symbol)) {
                return op;
            }
        }
        throw new IllegalArgumentException();
    }

}
