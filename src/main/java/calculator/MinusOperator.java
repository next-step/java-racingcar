package calculator;

public class MinusOperator implements Operator{
    @Override
    public Integer operate(Integer first, Integer second) {
        return first - second;
    }
}
