package calculator.operator;

public class Multiplication implements Operator {
    @Override
    public Long action(Long x, Long y) {
        return x*y;
    }
}
