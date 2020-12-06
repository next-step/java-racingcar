package calculator.operaor;

public class Multiply implements Operator {
    @Override
    public int operate(int operandA, int operandB) {
        return operandA * operandB;
    }
}
