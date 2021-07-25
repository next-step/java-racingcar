package stringcalculator;

public class MinusOperator implements Operator {
    private static final String SYMBOL = "-";
    private static final MinusOperator INSTANCE = new MinusOperator();

    private MinusOperator() {}

    public static Operator getInstance() {
        return INSTANCE;
    }

    @Override
    public int calculate(int x, int y) {
        return x - y;
    }

    @Override
    public boolean match(String symbol) {
        return MinusOperator.SYMBOL.equals(symbol);
    }
}
