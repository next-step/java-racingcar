package pobiStringCalculator;

public class PlusOperation implements Operation {
    @Override
    public boolean isSupport(String operator) {
        return operator.equals("+");
    }
}