package calculator;

public class Multiplication implements Operator {
    @Override
    public int calculate(int operand1, int operand2) {
        return operand1 * operand2;
    }
}
