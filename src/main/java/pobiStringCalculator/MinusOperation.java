package pobiStringCalculator;

public class MinusOperation implements Operation {
    @Override
    public boolean isSupport(String operator) {
        return operator.equals("-");
    }
}