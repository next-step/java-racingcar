package calculator;

public class DivideOperator implements Operator {

    @Override
    public int operate(final int val1, final int val2) {
        if(val2 == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return val1 / val2;
    }
}
