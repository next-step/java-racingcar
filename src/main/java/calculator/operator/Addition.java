package calculator.operator;

public class Addition implements Operator {
    @Override
    public Long action(Long x, Long y) {
        return x+y;
    }
}
