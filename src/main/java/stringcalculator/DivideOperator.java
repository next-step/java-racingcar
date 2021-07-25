package stringcalculator;

public class DivideOperator implements Operator {
    private static final String SYMBOL = "/";
    private static final DivideOperator INSTANCE = new DivideOperator();

    private DivideOperator() {}

    public static Operator getInstance() {
        return INSTANCE;
    }

    @Override
    public int calculate(int x, int y) {
        return x / y;
    }

    @Override
    public boolean match(String symbol) {
        return DivideOperator.SYMBOL.equals(symbol);
    }
}
