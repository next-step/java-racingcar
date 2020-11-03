package calculator.operator;

public class Subtraction implements Operator {
    @Override
    public Long action(Long x, Long y) {
        return x-y;
    }
}
