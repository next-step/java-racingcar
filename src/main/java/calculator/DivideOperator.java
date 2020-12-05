package calculator;

public class DivideOperator implements Operator{
    private static final int ZERO = 0;

    @Override
    public Integer operate(Integer first, Integer second) {
        if(second == ZERO) {
            return ZERO;
        }
        return first / second;
    }
}
