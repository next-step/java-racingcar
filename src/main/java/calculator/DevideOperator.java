package calculator;

public class DevideOperator implements Operator{
    @Override
    public Integer operate(Integer first, Integer second) {
        return first / second;
    }
}
