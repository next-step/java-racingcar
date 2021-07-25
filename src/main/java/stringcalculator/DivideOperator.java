package stringcalculator;

public class DivideOperator implements Operator {
    private static final String symbol = "/";
    private static final DivideOperator instance = new DivideOperator();

    private DivideOperator() {}

    public static Operator getInstance() {
        return instance;
    }

    @Override
    public int calculate(int x, int y) {
        return x / y;
    }

    @Override
    public boolean match(String symbol) {
        return DivideOperator.symbol.equals(symbol);
    }
}
