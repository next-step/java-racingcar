package calculator;

public class MultiplyOperator implements Operator{
    @Override
    public Integer operate(Integer first, Integer second) {
        return first * second;
    }
}
