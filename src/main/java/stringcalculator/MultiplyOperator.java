package stringcalculator;

public class MultiplyOperator implements Operator {
    private static final String symbol = "*";
    private static final MultiplyOperator instance = new MultiplyOperator();

    private MultiplyOperator() {}

    public static Operator getInstance() {
        return instance;
    }
    @Override
    public int calculate(int x, int y) {
        return x * y;
    }

    @Override
    public boolean match(String symbol) {
        return MultiplyOperator.symbol.equals(symbol);
    }
}
