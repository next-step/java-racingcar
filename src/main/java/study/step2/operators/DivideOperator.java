package study.step2.operators;

public class DivideOperator implements Operator {
    @Override
    public int evaluate(int value1, int value2) {
        if (value2 == 0) {
            throw new IllegalArgumentException("Divided by zero.");
        }
        return value1 / value2;
    }
}
