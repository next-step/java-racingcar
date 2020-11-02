package calculator.domain;

public class AddOperator implements Operator {

    @Override
    public int apply(int x, int y) {
        return x + y;
    }
}
