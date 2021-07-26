package stringcalculator;

public class PlusOperator implements Operator {
    private static final String SYMBOL = "+";
    private static final PlusOperator INSTANCE = new PlusOperator();

    private PlusOperator() {}

    public static Operator getInstance() {
        return INSTANCE;
    }

    @Override
    public int calculate(int x, int y) {
        return x + y;
    }

    @Override
    public boolean match(String symbol) {
        return PlusOperator.SYMBOL.equals(symbol);
    }
}
