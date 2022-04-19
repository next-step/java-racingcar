package racing.util;

public enum Delimiter {
    COMMA(","),
    NEW_LINE("\n");

    public final String symbol;

    Delimiter(String symbol) {
        this.symbol = symbol;
    }
}
