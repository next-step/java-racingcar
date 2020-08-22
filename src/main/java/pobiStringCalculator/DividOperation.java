package pobiStringCalculator;

public class DividOperation implements Operation {
    @Override
    public boolean isSupport(String operator) {
        return operator.equals("/");
    }

}