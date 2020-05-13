package step2;

public enum Symbol {

    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private String symbol;

    Symbol(String symbol) { this.symbol = symbol; }

    public boolean isEqualTo(String symbol) { return this.symbol.equals(symbol); }
}
