package calculator.domain;

public class SubtractOperator implements Operator {

    @Override
    public int apply(int x, int y) {
        return x - y;
    }
}
