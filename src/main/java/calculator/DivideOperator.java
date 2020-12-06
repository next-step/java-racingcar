package calculator;

public class DivideOperator implements Operator{
    private static final int ZERO = 0;

    @Override
    public Integer operate(Integer first, Integer second) {
        if(second == ZERO) {
            throw new IllegalArgumentException("0 으로 나눌 수 없습니다.");
        }
        return first / second;
    }
}
