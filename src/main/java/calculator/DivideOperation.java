package calculator;

import stringcalculator.Constants;

public class DivideOperation implements Operation {
    @Override
    public boolean isSupport(String operator) {
        return operator.equals("/");
    }

    @Override
    public int operate(int x, int y) {
        if (y == 0) {
            throw new ArithmeticException(Constants.DIVIDE_BY_ZERO);
        }
        return x / y;
    }
}
