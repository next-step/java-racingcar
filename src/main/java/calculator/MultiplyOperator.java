package calculator;

public class MultiplyOperator implements Operator {

    @Override
    public int operate(final int val1, final int val2) {
        return val1 * val2;
    }
}
