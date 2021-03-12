package calculator.operators;

public class SubtractOperator implements Operator{
    @Override
    public int operate(int num1, int num2) {
        return num1 - num2;
    }
}
