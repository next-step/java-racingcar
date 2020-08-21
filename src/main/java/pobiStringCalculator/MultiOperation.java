package pobiStringCalculator;

public class MultiOperation implements Operation {
    @Override
    public boolean isSupport(String operator) {
        return operator.equals("*");
    }

    @Override
    public int operate(int x, int y) {
        return x * y;
    }
}