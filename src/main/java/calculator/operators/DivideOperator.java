package calculator.operators;

public class DivideOperator implements Operator{
    @Override
    public int operate(int num1, int num2) {
        return num1 / num2;
    }
}
