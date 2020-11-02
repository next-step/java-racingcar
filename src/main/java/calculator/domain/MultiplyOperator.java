package calculator.domain;

public class MultiplyOperator implements Operator {

    @Override
    public int apply(int x, int y) {
        return x * y;
    }
}
