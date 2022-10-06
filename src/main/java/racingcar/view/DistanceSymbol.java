package racingcar.view;

public class DistanceSymbol {
    private static final DistanceSymbol DEFAULT_SYMBOL = new DistanceSymbol("-");
    
    private final String symbol;

    public DistanceSymbol(String symbol) {
        this.symbol = symbol;
    }

    public static DistanceSymbol of(String[] args) {
        if (args == null || args.length < 1 || args[0].isEmpty()) {
            return DEFAULT_SYMBOL;
        }
        return new DistanceSymbol(args[0]);
    }
    
    public String value() {
        return symbol;
    }
}
