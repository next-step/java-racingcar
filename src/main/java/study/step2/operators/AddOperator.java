package study.step2.operators;

public class AddOperator implements Operator {
    @Override
    public int evaluate(int value1, int value2) {
        return value1 + value2;
    }
}
