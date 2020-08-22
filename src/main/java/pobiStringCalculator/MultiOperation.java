package pobiStringCalculator;

public class MultiOperation implements Operation {
    @Override
    public boolean isSupport(String operator) {
        return operator.equals("*");
    }
}