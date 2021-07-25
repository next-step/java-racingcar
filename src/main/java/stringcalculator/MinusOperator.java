package stringcalculator;

public class MinusOperator implements Operator {
    private static final String symbol = "-";
    private static final MinusOperator instance = new MinusOperator();

    private MinusOperator() {}

    public static Operator getInstance() {
        return instance;
    }

    @Override
    public int calculate(int x, int y) {
        return x - y;
    }

    @Override
    public boolean match(String symbol) {
        return MinusOperator.symbol.equals(symbol);
    }
}
