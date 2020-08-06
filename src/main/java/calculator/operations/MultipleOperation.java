package calculator.operations;

import calculator.Operation;

public class MultipleOperation implements Operation {

    @Override
    public boolean isSupport(String operator) {
        return "*".equals(operator);
    }

    @Override
    public int operate(int a, int b) {
        return a * b;
    }
}
