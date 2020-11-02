package calculator.domain;

public class DivideOperator implements Operator {

    @Override
    public int apply(int x, int y) {
        if (y == 0) throw new IllegalArgumentException("제수는 0이 될 수 없습니다.");

        return x / y;
    }
}
