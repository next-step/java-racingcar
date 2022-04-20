package racing.util;

public enum Behavior {
    FORWARD("-"), STOP("");

    public final String symbol;

    Behavior(String symbol) {
        this.symbol = symbol;
    }
}
