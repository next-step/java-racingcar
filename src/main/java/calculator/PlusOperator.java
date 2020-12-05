package calculator;

public class PlusOperator implements Operator{
    @Override
    public Integer operate(Integer first, Integer second) {
        return first + second;
    }
}
