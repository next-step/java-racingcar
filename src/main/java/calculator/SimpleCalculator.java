package calculator;

public class SimpleCalculator extends Calculator {

    @Override
    protected String[] operands(String str) {
        return str.split(Constants.BASE_SEPARATOR_REGEX);
    }
}
