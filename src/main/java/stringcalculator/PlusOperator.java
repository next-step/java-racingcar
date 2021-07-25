package stringcalculator;

public class PlusOperator implements Operator {
    private static final String symbol = "+";
    private static final PlusOperator instance = new PlusOperator();

    private PlusOperator() {}

    public static Operator getInstance() {
        return instance;
    }

    @Override
    public int calculate(int x, int y) {
        return x + y;
    }

    @Override
    public boolean match(String symbol) {
        return PlusOperator.symbol.equals(symbol);
    }
}
